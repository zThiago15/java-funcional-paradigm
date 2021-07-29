package one.innovation.digital.aula6;

public class StringRepeat {
    public static void main(String[] args) {
        // Objetivo: printe seu nome 10 vezes

        System.out.println("Usando for: ");
        var nome = "Thiago";
        var aux = "";

        for(int i = 0; i < 10; i++){
            aux += nome;
        }
        System.out.println(aux);
        System.out.println();

        System.out.println("Usando a função repeat");

        System.out.println(nome.repeat(10));
    }
}
