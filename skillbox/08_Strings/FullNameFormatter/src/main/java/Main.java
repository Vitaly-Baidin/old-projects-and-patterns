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
      //При невалидном ФИО вывести в консоль: Введенная строка не является ФИО
      // Иванов Иван Иванович
      boolean flag = true;
      int countSpace = 0;

      for (int i = 0; i <= 9; i++) {
        if (input.indexOf(i + "") >= 0) {
          System.out.println("Введенная строка не является ФИО");
          flag = false;
          break;
        }
      }

      for (char i = 'A'; i <= 'z'; i++) {
        if (input.indexOf(i + "") >= 0) {
          System.out.println("Введенная строка не является ФИО");
          flag = false;
          break;
        }
      }

      if (input.indexOf(" ") == -1) {
        System.out.println("Введенная строка не является ФИО");
        flag = false;
        break;
      }

      if (input.substring(input.indexOf(" ") + 1, input.lastIndexOf(" ")).indexOf(" ") >= 0) {
        System.out.println("Введенная строка не является ФИО");
        flag = false;
        break;
      }

      if (flag) {
        int firstIndex = input.indexOf(" ");
        int lastIndex = input.lastIndexOf(" ");

        String firstName = input.substring(0,firstIndex);
        String lastName = input.substring(firstIndex + 1, lastIndex);
        String otherName = input.substring(lastIndex + 1);

        System.out.println("Фамилия: " + firstName);
        System.out.println("Имя: " + lastName);
        System.out.println("Отчество: " + otherName);
      }


    }
  }

}