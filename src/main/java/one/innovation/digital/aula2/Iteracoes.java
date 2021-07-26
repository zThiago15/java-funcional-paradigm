package one.innovation.digital.aula2;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Iteracoes {

    public static void main(String[] args) {

        String[] nomes = {"Thiago", "Joao", "Joao", "Rafaella", "Elisangela", "Gustavo"};
        Integer[] numeros = {1,2,3,4,5};
        //imprimirNomesFiltrados(nomes);
        imprimirTodosOsNomes(nomes);
    }

    public static void imprimirNomesFiltrados(String... nomes){

        String nomesParaImprimir = "";

        // Utilizando for
        for(int i = 0; i < nomes.length; i++){
            if (nomes[i].equals("Joao")){
                nomesParaImprimir += " "+nomes[i];
            }
        }

        System.out.println("Nomes da estrutura de repetição for: "+nomesParaImprimir);

        // Utilizando stream
        String nomesParaImprimirDaStream = Stream.of(nomes)
                .filter(nome -> nome.equals("Joao"))
                .collect(Collectors.joining()); // Transforma os elementos do Array em apenas uma string

        System.out.println("Nomes da stream: "+nomesParaImprimirDaStream);
    }

    public static void imprimirTodosOsNomes(String... nomes){
        for(String nome: nomes){
            System.out.println("Imprimindo pela estrutura for: "+nome);
        }

        Stream.of(nomes)
                .forEach(nome -> System.out.println("Imprimindo pelo forEach: "+nome));

    }

    public static void imprimirODobroDeCadaItemDaLista(Integer... numeros){
        for(Integer numero: numeros){
            System.out.println(numero*2); //Imprimir o dobro de cada número do Array
        }
    }


}
