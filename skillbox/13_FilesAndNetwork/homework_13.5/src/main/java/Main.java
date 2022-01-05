import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        final String URL = "https://www.moscowmap.ru/metro.html#lines";
        ArrayList<Line> lines = new ArrayList<>();
        JSONObject metroList = new JSONObject();
        JSONObject stationsJSON = new JSONObject();
        JSONArray linesJSON = new JSONArray();


        try {
            Document document = Jsoup.connect(URL).maxBodySize(0).get();

            Elements line = document.select(".js-metro-line");

            line.stream().forEach(e1 -> {
                lines.add(new Line(e1.ownText(), e1.attr("data-line")));
                document.select("div > div[data-line=" + e1.attr("data-line") + "] .name")
                        .stream().forEach(e2 -> lines.get(lines.size() - 1).addStation(new Station(e2.ownText(), e1.attr("data-line"))));
            });


        } catch (IOException ex) {
            ex.printStackTrace();
        }

        lines.stream().forEach(e1 -> {
            JSONArray stationDetails = new JSONArray();
            JSONObject lineDetails = new JSONObject();

            stationDetails.addAll(e1.getStations());
            lineDetails.put("number", e1.getNumberLine());
            lineDetails.put("name", e1.getName());

            stationsJSON.put(e1.getNumberLine(), stationDetails);
            linesJSON.add(lineDetails);
        });

        metroList.put("stations", stationsJSON);
        metroList.put("lines", linesJSON);

        try (FileWriter file = new FileWriter("/myWork/test/MoscowMetro.json")) {
            file.write(metroList.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
