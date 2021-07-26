package one.innovation.digital.aula1;

public class FuncaoComClasseAnonima {
    public static void main(String[] args) {

        // Depreciado
        Funcao colocarPrefixoSenhorNaString = new Funcao() {
            @Override
            public String gerar(String valor) {
                return "Sr. " + valor;
            }
        };
        System.out.println(colocarPrefixoSenhorNaString.gerar("João"));


    }
}
