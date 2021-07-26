package one.innovation.digital.aula2;


import java.util.function.Consumer;

public class Consumidores {

    public static void main(String[] args) {

        Consumer<String> imprimirUmaFrase = System.out::println; //Usando method reference

        //Consumer<String> imprimirUmaFrase = frase -> System.out.println(frase);
        imprimirUmaFrase.accept("Hello world");
    }
}
