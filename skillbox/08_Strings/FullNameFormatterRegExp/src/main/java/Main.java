import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    while (true) {
      String input = scanner.nextLine();
      if (input.equals("0")) {
        break;
      }
      //TODO:напишите ваш код тут, результат вывести в консоль.
      //При невалидном ФИО вывести в консоль: Введенная строка не является ФИО

      String regex = "\\s+";
      String regexFindErr = "[0-9\\s]+";
      String[] words = input.split(regex);
      if (input.matches(regexFindErr) || words.length < 3 || words.length > 3) {
        System.out.println("Введенная строка не является ФИО");
      } else {
        System.out.println("Фамилия: " + words[0]);
        System.out.println("Имя: " + words[1]);
        System.out.println("Отчество: " + words[2]);
      }
    }
  }

}