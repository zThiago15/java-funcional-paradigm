package one.innovation.digital.aula1;

import java.util.function.BiPredicate;

public class PureFunctions {

    public static void main(String[] args) {
        BiPredicate<Integer, Integer> checaSeEMaior =
                (parametro, valorComparado) -> parametro > valorComparado;

        System.out.println(checaSeEMaior.test(8,7)); // 8 > 7 ? true
        System.out.println(checaSeEMaior.test(8,7));
    }
}
