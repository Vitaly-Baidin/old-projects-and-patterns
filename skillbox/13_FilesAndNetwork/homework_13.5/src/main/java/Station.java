public class Station {
    private String name;
    private String lineStation;

    public Station(String name, String lineStation) {
        this.name = name;
        this.lineStation = lineStation;
    }

    public String getName() {
        return name;
    }

    public String getLineStation() {
        return lineStation;
    }

    public String toString() {
        return "\"" + name + "\"";
    }
}
