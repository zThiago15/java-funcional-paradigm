package one.innovation.digital.aula5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.stream.Collectors;

public class InferenciaExemplo {

    public static void main(String[] args) throws IOException{

        testar("Thiago", "Dias");

        realizarSoma2Numeros(5 ,10);

        realizarVariasSomas(10, 5, 5);
    }

    public static void connectAndPrintJavaOracleURL() throws IOException{
        URL url = new URL("https://docs.oracle.com/javase/10/language/");
        URLConnection urlConnection = url.openConnection();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

        System.out.println(bufferedReader.lines().collect(Collectors.joining()).replaceAll(">", ">\n"));
    }

    public static void testar(String nome, String sobrenome){

        var nomeCompleto = String.format("%s %s", nome, sobrenome);
        System.out.println(nomeCompleto);
    }

    public static void realizarSoma2Numeros(int a, int b){
        var soma = a + b;
        System.out.println(soma);
    }

    public static void realizarVariasSomas(int... numero){ //Array -> ...
        int soma;
        if(numero.length > 0){
            soma = 0;
            for(var i = 0; i < numero.length; i++){
                soma += numero[i];
            }

            System.out.println(soma);
        }
    }

}
