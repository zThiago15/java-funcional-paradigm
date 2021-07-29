package one.innovation.digital.aula6;

import jdk.dynalink.linker.LinkerServices;

import java.io.IOException;
import java.net.ProxySelector;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class HttpClientExample {

    static ExecutorService executor = Executors.newFixedThreadPool(6, new ThreadFactory() {
        @Override
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);

            System.out.println("Nova thread criada: "+ (thread.isDaemon() ? "daemon" : "") + " Thread Group: "+thread.getThreadGroup()); //Quando novas threads forem criadas, aparecerá essa msg
            return thread;
        }
    });

    public static void main(String[] args) throws Exception {
        connectAndPrintURLJavaOracle();
    }


    public static void connectAkamaiHttpClient() throws Exception {
        System.out.println("Running Http 1.1 client");

        try{
            HttpClient httpClient = HttpClient.newBuilder()
                    .version(HttpClient.Version.HTTP_1_1)
                    .proxy(ProxySelector.getDefault())
                    .build();

            long start = System.currentTimeMillis();

            HttpRequest mainRequest = HttpRequest.newBuilder()
                    .uri(URI.create("https://http2.akamai.com/demo/h2_demo_frame.html"))
                    .build();

            HttpResponse<String> response = httpClient.send(mainRequest, HttpResponse.BodyHandlers.ofString());

            System.out.println("Status code: "+ response.statusCode());
            System.out.println("Response headers: "+ response.headers());
            String responseBody = response.body();
            System.out.println(response.body());

            List<Future<?>> future = new ArrayList<>();


            responseBody
                    .lines()
                    .filter(line -> line.trim().startsWith("<img height"))
                    .map(line -> line.substring(line.indexOf("src='")+ 5, line.indexOf("'/>")))
                    .forEach(image -> {

                            Future<?> imgFuture = executor.submit(() -> {
                            HttpRequest imgRequest = HttpRequest.newBuilder()
                                    .uri(URI.create("https://http2.akamai.com"))
                                    .build();

                                try {
                                    HttpResponse<String> imageResponse = httpClient.send(imgRequest, HttpResponse.BodyHandlers.ofString());
                                    System.out.println("Imagem carregada: "+image+ ", status code: "+ imageResponse.statusCode());

                                } catch (IOException | InterruptedException e) {
                                    System.out.println("Mensagem de erro durante requisição para recuperar a image"+ image);
                                }

                    });
                            future.add(imgFuture);
                        System.out.println("Submetida um futuro para imagem "+image);
                });

            future.forEach(f -> {
                try {
                    f.get();
                } catch (InterruptedException | ExecutionException e) {
                    System.out.println("Erro ao esperar carregar imagem do futuro");
                }
            });

            long end = System.currentTimeMillis();
            System.out.println("Tempo de carregamento total: " + (end - start)+ "ms");

        } finally {
            executor.shutdown();
        }


    }

    public static void connectAndPrintURLJavaOracle() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .GET().uri(URI.create("https://docs.oracle.com/javase/10/language"))
                .build(); // O que estou pedindo para o servidor

        HttpClient httpClient = HttpClient.newHttpClient();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString()); // Faz a execução do request

        System.out.println("Status code: "+ response.statusCode()); // Código de status. Ex: 4**(Erro do cliente), 5**(Erro do servidor)
        System.out.println("Headers response: "+ response.headers()); // Dados do cabeçalho do site
        System.out.println(response.body()); // O conteúdo da requisição
    }
}
