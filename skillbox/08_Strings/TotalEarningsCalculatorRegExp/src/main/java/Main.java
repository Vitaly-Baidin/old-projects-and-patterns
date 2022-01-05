import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

  public static void main(String[] args) {
    String text = "Вася заработал 12 мая 5000 рублей, Петя 14 февраля - 7563 рубля, а Маша 16 января - 30000 рублей";
    calculateSalarySum(text);
  }

  public static int calculateSalarySum(String text){
    //TODO: реализуйте метод
    int total = 0;

    String regexSearch = "[0-9]+ [р]";
    Pattern pattern = Pattern.compile(regexSearch);
    Matcher matcher = pattern.matcher(text);

    while (matcher.find()) {
      total += Integer.parseInt(text.substring(matcher.start(), matcher.end() - 2));
    }
    return total;
  }

}