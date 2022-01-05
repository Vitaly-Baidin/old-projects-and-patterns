import java.util.Scanner;

public class Main {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    while (true) {
      String input = scanner.nextLine();
      if (input.equals("0")) {
        break;
      }
      //TODO:напишите ваш код тут, результат вывести в консоль.
      String regex = "[^0-9]";

      input = input.replaceAll(regex, "");
      if ((input.length() == 11 && input.matches("[+]?[7-8]+[0-9]+")) || (input.matches("[+]?[0-9]+[0-9]+") && input.length() == 10)) {
        if (input.matches("[8][0-9]+")) {
          input = input.replaceAll("\\b8","7");
        } else if (input.length() == 10) {
          input = input.replaceAll("^","7");
        }
        System.out.println(input);
      } else if (true) {
        System.out.println("Неверный формат номера");
      } else {
        System.out.println("Неверный формат номера");
      }

//      if (input.matches("[0-9]{10,11}") && input.matches("[+]?[0-9]+[0-9]+")) {
//        if (input.matches("[8][0-9]+")) {
//          input = input.replaceAll("\\b8","7");
//        } else if (input.matches("[0-9]{10}")) {
//          input = input.replaceAll("\\b","7");
//        }
//        System.out.println(input);
//      } else {
//        System.out.println("Неверный формат номера");
//      }
    }
  }

}
