package one.innovation.digital.aula3;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class ExemploParallelStream {

    public static void main(String[] args) {
        long inicio = System.currentTimeMillis(); //tempo atual
        IntStream.range(1, 1000000).forEach(num -> fatorial(num)); //Serial
        long fim = System.currentTimeMillis();
        System.out.println("Tempo de execução: "+ (fim-inicio));


        inicio = System.currentTimeMillis(); //tempo atual
        IntStream.range(1, 1000000).parallel().forEach(num -> fatorial(num)); //Parallel
        fim = System.currentTimeMillis();
        System.out.println("Tempo de execução: "+ (fim-inicio));

        List<String> nomes = Arrays.asList("João", "Sara", "Thiago", "Bianca");
        nomes.parallelStream().forEach(System.out::println);

    }

    public static long fatorial(long num){
        long fat = 1;

        for(long i =2; i < fat; i++){
            fat *= i;
        }
        return fat;
    }


}
