import org.jsoup.Jsoup;
import org.jsoup.select.Elements;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Parse parse = new Parse("https://lenta.ru/");
        Elements elements = parse.getElementByTag("img");
        String directoryName = "/media/test/";
        List<String> urlElements = elements.stream().map(e -> e.attr("abs:src")).toList();

        System.out.println("Процесс загрузки:");

        for (String elem : urlElements) {
            int endIndex = elem.lastIndexOf("/");
            String fileName = elem.substring(endIndex + 1);

            System.out.println("Загружаю: " + fileName);
            System.out.println("В  папку: " + directoryName);

            try {
                URL url = new URL(elem);
                InputStream in = url.openStream();

                OutputStream out = new BufferedOutputStream(new FileOutputStream( directoryName + fileName));

                for (int b; (b = in.read()) != -1;) {
                    out.write(b);
                }

                out.close();
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Все файлы загружены");
        }
    }
}
