package one.innovation.digital.aula1;

import java.util.Arrays;

public class FunctionCompositions {

    public static void main(String[] args) {

        int[] numbers = {1,2,3,4,5};

        // Funcional
        Arrays.stream(numbers)
                .filter(number -> number % 2 == 0) //It'll filter just even numbers
                .map(number -> number * 2) // Map will transform values
                .forEach(number -> System.out.println(number)); //For each number, it'll print it


        // Imperative
        for(int i = 0; i < numbers.length; i++){
            int valor = 0;
            if(numbers[i] % 2 == 0){
                valor = numbers[i] * 2;

                if(valor != 0){
                    System.out.println(valor);
                }
            }
        }


    }
}
