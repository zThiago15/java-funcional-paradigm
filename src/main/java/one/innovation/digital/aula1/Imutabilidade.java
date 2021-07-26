package one.innovation.digital.aula1;

import java.util.function.UnaryOperator;

public class Imutabilidade {

    public static void main(String[] args) {

        int valor = 40;
        UnaryOperator<Integer> retornaDobro = v -> v * 2;
        System.out.println(retornaDobro.apply(valor));
        System.out.println(valor); //value of the variable not changed
    }
}
