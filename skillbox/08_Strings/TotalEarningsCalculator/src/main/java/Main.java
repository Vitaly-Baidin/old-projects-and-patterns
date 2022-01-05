public class Main {

  public static void main(String[] args) {
//
    String text = "Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей";
    //TODO: напишите ваш код, результат вывести в консоль
    System.out.println(getTotalEarningCalculator(text));
  }

  public static int getTotalEarningCalculator(String text) {
    String earnStr = " руб";
    int start = 0;
    int end = 0;
    int total = 0;

    for (int i = 0; i < 3; i++) {
      if (i == 0) {
        start = text.lastIndexOf(earnStr);
        end = text.lastIndexOf(" ", start - 1);
      } else {
        start = text.lastIndexOf(earnStr, end);
        end = text.lastIndexOf(" ", start - 1);
      }

      total += Integer.parseInt(text.substring(end, start).trim());
    }

    return total;
  }

}