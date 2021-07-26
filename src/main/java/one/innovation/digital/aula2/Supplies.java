package one.innovation.digital.aula2;

import java.util.function.Supplier;

public class Supplies {

    public static void main(String[] args) {
        Supplier<Pessoa> instanciarPessoa = () -> new Pessoa();
        Supplier<Pessoa> instanciarPessoa2 = Pessoa::new;
        System.out.println(instanciarPessoa.get());
        System.out.println(instanciarPessoa2.get());
    }
}

class Pessoa {
    private String nome;
    private Integer idade;
    private String genero;

    public Pessoa(){
        nome = "Thiago";
        idade = 19;
        genero = "M";
    }

    @Override
    public String toString(){ //Trata os dados
        return String.format("nome : %s, idade: %d, genero: %s", nome, idade, genero);
    }

}