package one.innovation.digital.aula1;

import java.util.HashMap;
import java.util.Map;

public class FatorialMemorization {

    static Map<Integer, Integer> MAPA_FATORIAL = new HashMap<>();
    public static void main(String[] args) {
        long T = System.nanoTime();
        System.out.println(fatorialComMemorization(15));
        long F = System.nanoTime();
        System.out.println("Fatorial 1 "+ (F-T));

        T = System.nanoTime();
        System.out.println(fatorialComMemorization(15));
        F = System.nanoTime();
        System.out.println("Fatorial 2 " + (F-T));
    }

    public static Integer fatorialComMemorization(Integer value) {
        if (value == 1) {
            return value;
        } else {
            if (MAPA_FATORIAL.containsKey(value)){
                return MAPA_FATORIAL.get(value);
            } else {
                Integer resultado = value * fatorialComMemorization(value -1);
                return resultado;
            }
        }
    }
}
