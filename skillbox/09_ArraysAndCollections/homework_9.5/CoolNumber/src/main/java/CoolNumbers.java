import java.util.*;

public class CoolNumbers {

    public static List<String> generateCoolNumbers() {
        ArrayList<String> listNumbers = new ArrayList<>();
        String[] goodLetters = {"А", "В", "Е", "К", "М", "Н", "О", "Р", "С", "Т", "У", "Х"};
        for (int regionCount = 1; regionCount < 200; regionCount++) {
            for (int coolCount = 1; coolCount < 10; coolCount++) {
                for (int i = 0; i < 12; i++) {
                    for (int j = 0; j < 12; j++) {
                        for (int k = 0; k < 12; k++) {
                            if (regionCount < 10) {
                                listNumbers.add(goodLetters[i] + (coolCount * 111) + goodLetters[j] + goodLetters[k] + "0" + regionCount);
                            } else {
                                listNumbers.add(goodLetters[i] + (coolCount * 111) + goodLetters[j] + goodLetters[k] + regionCount);
                            }
                        }
                    }
                }
            }
        }
        return listNumbers;
    }

    public static boolean bruteForceSearchInList(List<String> list, String number) {
        for (String elem : list) {
            if(elem.equals(number)) {
                return true;
            }
        }
        return false;
    }

    public static boolean binarySearchInList(List<String> sortedList, String number) {
        if (Collections.binarySearch(sortedList, number) >= 0) {
            return true;
        }
        return false;
    }


    public static boolean searchInHashSet(HashSet<String> hashSet, String number) {
        if (hashSet.contains(number)) {
            return true;
        }
        return false;
    }

    public static boolean searchInTreeSet(TreeSet<String> treeSet, String number) {
        if (treeSet.contains(number)) {
            return true;
        }
        return false;
    }

}
