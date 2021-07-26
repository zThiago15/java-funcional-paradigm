package one.innovation.digital.aula2;

public class FuncaoAltaOrdem {

    public static void main(String[] args) {
        Calculo SOMA = (a, b)-> a+b;
        Calculo SUBTRACAO = (a, b)-> a-b;
        Calculo MULTIPLICACAO = (a,b) -> a*b;
        Calculo DIVISAO = (a,b) -> a/b;

        System.out.println(executarOperacao(SOMA, 1, 3)); //4
        System.out.println(executarOperacao(SUBTRACAO, 5, 2)); //3
        System.out.println(executarOperacao(MULTIPLICACAO, 2, 1)); // 2
        System.out.println(executarOperacao(DIVISAO, 5, 5)); //1
    }

    public static int executarOperacao(Calculo calculo, int a, int b){
        return calculo.calcular(a, b);
    }


}

@FunctionalInterface
interface Calculo{
    public int calcular(int a, int b);

}