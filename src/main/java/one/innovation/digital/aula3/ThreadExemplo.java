package one.innovation.digital.aula3;

public class ThreadExemplo {

    public static void main(String[] args) {

        GeradorPDF iniciarGeradorPdf = new GeradorPDF();
        BarraDeCarregamento iniciarBarraDeCarregamento = new BarraDeCarregamento(iniciarGeradorPdf);

        iniciarGeradorPdf.start();
        iniciarBarraDeCarregamento.start();

    }
}

class GeradorPDF extends Thread {

    @Override
    public void run(){

        try {
            System.out.println("Iniciar geração de PDF ");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("PDF Gerado");
    }
}

class BarraDeCarregamento extends Thread {

    private Thread iniciarGeradorPdf;

    public BarraDeCarregamento(Thread iniciarGeradorPdf) {
        this.iniciarGeradorPdf = iniciarGeradorPdf;
    }

    @Override
    public void run() {
        // Enquanto a thread estiver viva, irá mostrar "Loading..", se não, irá parar e mostrar o "Gerar PDF"
        while (true) {
            try {
                Thread.sleep(500);

                if (iniciarGeradorPdf.isAlive()) {
                    break;
                }
                System.out.println("Loading...");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

}
