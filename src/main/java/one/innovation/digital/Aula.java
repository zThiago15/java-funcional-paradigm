package one.innovation.digital;

public class Aula {

    public static void main(String[] args) {
        Funcao1 funcao = valor -> {

            return valor;
        };
        System.out.println(funcao.gerar("Thiago"));

    }
}

@FunctionalInterface
interface Funcao1 {
    String gerar(String valor);
}