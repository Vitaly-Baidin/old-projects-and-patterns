import java.util.*;

public class Main {
    /*
    TODO:
     - реализовать методы класса CoolNumbers
     - посчитать время поиска введимого номера в консоль в каждой из структуры данных
     - проанализоровать полученные данные
     */

    public static void main(String[] args) {
        long timeStart;
        long timeEnd;
        boolean bool;

        Scanner scanner = new Scanner(System.in);
        List<String> coolNumList = CoolNumbers.generateCoolNumbers();
        HashSet<String> coolNumHashSet = new HashSet<>(coolNumList);
        TreeSet<String> coolNumTreeSet = new TreeSet<>(coolNumList);

        while (true) {
            String input = scanner.nextLine();

            timeStart = System.nanoTime();
            bool = CoolNumbers.bruteForceSearchInList(coolNumList, input);
            timeEnd = System.nanoTime();
            System.out.println("Поиск перебором: номер " + (bool ? "найден" : "не найден") + " поиск занял " + (timeEnd - timeStart) + "нс");

            Collections.sort(coolNumList);
            timeStart = System.nanoTime();
            bool = CoolNumbers.binarySearchInList(coolNumList, input);
            timeEnd = System.nanoTime();
            System.out.println("Бинарный поиск: номер " + (bool ? "найден" : "не найден") + " поиск занял " + (timeEnd - timeStart) + "нс");

            timeStart = System.nanoTime();
            bool = CoolNumbers.searchInHashSet(coolNumHashSet, input);
            timeEnd = System.nanoTime();
            System.out.println("Поиск в HashSet: номер " + (bool ? "найден" : "не найден") + " поиск занял " + (timeEnd - timeStart) + "нс");

            timeStart = System.nanoTime();
            bool = CoolNumbers.searchInTreeSet(coolNumTreeSet, input);
            timeEnd = System.nanoTime();
            System.out.println("Поиск в TreeSet: номер " + (bool ? "найден" : "не найден") + " поиск занял " + (timeEnd - timeStart) + "нс");
        }




    }
}
