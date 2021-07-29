package one.innovation.digital.aula6;

import java.util.function.Function;

public class InferenciaLambda {
    public static void main(String[] args) {

        String espaco = "                                                             ";
        //System.out.println(espaco == null || espaco.length() == 0 || espaco.chars().allMatch( c -> c == ' ')); //false, false e true
        System.out.println(espaco.isBlank());
    }
}
