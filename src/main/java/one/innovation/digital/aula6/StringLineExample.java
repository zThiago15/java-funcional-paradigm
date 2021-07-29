package one.innovation.digital.aula6;

import java.util.stream.Collectors;

public class StringLineExample {

    public static void main(String[] args) {
        String html = "<html>\n <head> \n </head> \n <body>\n </body> \n </html>";
        System.out.println(html.lines().map(s -> "[TAG] : "+ s + "\n").collect(Collectors.joining()));
    }
}
