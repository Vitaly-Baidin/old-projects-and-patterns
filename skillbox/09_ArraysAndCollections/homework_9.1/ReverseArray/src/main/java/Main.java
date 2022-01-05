public class Main {

    public static void main(String[] args) {
        String line = "Каждый охотник желает знать, где сидит фазан";
        String[] lineArr = line.split(",?\\s+");

        lineArr = ReverseArray.reverse(lineArr);

        for (String arrItem : lineArr) {
            System.out.println(arrItem);
        }
    }
}
