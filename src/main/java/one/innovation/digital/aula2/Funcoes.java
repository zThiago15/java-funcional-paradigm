package one.innovation.digital.aula2;

import java.util.function.Function;

public class Funcoes {

    public static void main(String[] args) {

        Function<String, String> retornaNomeAoContrario = texto -> new StringBuilder(texto).reverse().toString();
        Function<String, Integer> converteStringParaInteiroERetornaODobro = string -> Integer.valueOf(string) *2;

        System.out.println(retornaNomeAoContrario.apply("Thiago")); //ogaihT
        System.out.println(converteStringParaInteiroERetornaODobro.apply("20"));
    }
}
