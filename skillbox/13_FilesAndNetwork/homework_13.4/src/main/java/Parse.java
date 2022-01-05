import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Parse {
    private String URL;
    private Document document;

    public Parse(String URL) {
        String pattern = "((((https?|ftps?|gopher|telnet|nntp)://)|(mailto:|news:))(%[0-9A-Fa-f]{2}|[-()_.!~*';/?:@&=+$,A-Za-z0-9])+)([).!';/?:,][[:blank:]])?$";
        if(URL.matches(pattern)) {
            try {
                this.URL = URL;
                this.document = Jsoup.connect(URL).get();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }else {
            System.out.println("Некорректный URL");
        }

    }
    public Elements getElementByTag(String tag) {
        Elements elements = document.select(tag);
        return elements;
    }
}
