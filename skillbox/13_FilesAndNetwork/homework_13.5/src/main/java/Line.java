import java.util.ArrayList;

public class Line {
    private String name;
    private String numberLine;

    private ArrayList<Station> stations;

    public Line(String name, String numberLine) {
        this.name = name;
        this.numberLine = numberLine;
        stations = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getNumberLine() {
        return numberLine;
    }

    public ArrayList<Station> getStations() {
        return stations;
    }

    public void addStation(Station station) {
        stations.add(station);
    }

    public String toString() {

        return numberLine + " " + name;
    }
}
