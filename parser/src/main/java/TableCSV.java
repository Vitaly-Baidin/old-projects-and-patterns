import java.util.ArrayList;

public class TableCSV {
    private String title;
    private ArrayList<String> rows;

    public TableCSV(int countNS) {
        rows = new ArrayList<>();
        title = "Name,";
        for (int i = 0; i < countNS; i++) {
            title += "NS" + i + ",";
        }
        title += "expiration_date,owner_name,private_acc\n";
        rows.add(title);
    }

    public void addRow(String row) {
        rows.add(row + "\n");
    }

    public ArrayList<String> getRows() {
        return rows;
    }
}
