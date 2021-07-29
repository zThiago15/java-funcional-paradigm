package one.innovation.digital.aula3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureExample {

    private static final ExecutorService threadPool = Executors.newFixedThreadPool(1);

    public static void main(String[] args) {
        Casa casa = new Casa(new Quarto());
        casa.obterAfazeresDaCasa().forEach( atividade -> threadPool.execute(() -> atividade.realizar()));
        threadPool.shutdown();
    }
}

class Casa {
    private List<Comodo>  comodos;

    public Casa(Comodo... comodos) {
        this.comodos = Arrays.asList(comodos);
    }

    List<Atividade> obterAfazeresDaCasa(){
        return this.comodos.stream().map(Comodo::obterAfazeresDoComodo)
            .reduce(new ArrayList<Atividade>(), (pivo, atividades) -> {
                pivo.addAll(atividades);
                return pivo;
            });


    }

}

interface Atividade {
    void realizar();
}

abstract class Comodo {
    abstract List<Atividade> obterAfazeresDoComodo();
}

class Quarto extends Comodo {

    @Override
    List<Atividade> obterAfazeresDoComodo() {

        ArrayList<Atividade> objects = new ArrayList<>();

        objects.add(() -> this.getArrumarACasa());
        objects.add(() -> this.varrerQuarto());
        objects.add(() -> this.arrumarGuardaRoupa());

        return Arrays.asList(
                this::getArrumarACasa,
                this::varrerQuarto,
                this::arrumarGuardaRoupa
        );
    }

    private void arrumarGuardaRoupa(){
        System.out.println("Arrumar guarda roupa");
    }

    private void varrerQuarto(){
        System.out.println("Varrer o quarto");
    }

    private void getArrumarACasa(){
        System.out.println("Arrumar a casa");
    }

}