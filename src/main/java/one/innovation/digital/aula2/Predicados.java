package one.innovation.digital.aula2;

import java.util.function.Predicate;

public class Predicados {

    public static void main(String[] args) {

        //Predicate retorna boolean
        Predicate<String> estaVazio = valor -> valor.isEmpty();
        Predicate<String> estaVazioComMethodReference = String::isEmpty; //acessa o método isEmpty da classe Stringb

        Predicate<String> comChaves = valor -> {
                return valor.isEmpty();
        };

        System.out.println(estaVazio.test("")); //true
        System.out.println(estaVazio.test("fsddfs")); //false

        System.out.println(estaVazioComMethodReference.test(""));
        System.out.println(estaVazioComMethodReference.test("testando"));

    }
}
