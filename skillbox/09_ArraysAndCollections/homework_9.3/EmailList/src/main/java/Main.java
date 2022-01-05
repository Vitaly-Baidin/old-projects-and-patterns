import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static final String WRONG_EMAIL_ANSWER = "Неверный формат email";

    public static EmailList emailList = new EmailList();
    private static final String REGEX_EMAIL = "(\\w+\\.)*\\w+@(\\w+\\.)[A-Za-z]+";
    private static Pattern pattern;
    private static Matcher matcher;

    /* TODO:
        Пример вывода списка Email, после ввода команды LIST в консоль:
        test@test.com
        hello@mail.ru
        - каждый адрес с новой строки
        - список должен быть отсортирован по алфавиту
        - email в разных регистрах считается одинаковыми
           hello@skillbox.ru == HeLLO@SKILLbox.RU
        - вывод на печать должен быть в нижнем регистре
           hello@skillbox.ru
        Пример вывода сообщения об ошибке при неверном формате Email:
        "Неверный формат email"
    */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("0")) {
                break;
            }
            
            //TODO: write code here

            String[] strCommand = input.split(" ", 2);

            if (strCommand[0].equals("ADD") && strCommand.length == 2) {
                pattern = Pattern.compile(REGEX_EMAIL, Pattern.CASE_INSENSITIVE);
                matcher = pattern.matcher(strCommand[1]);
                if (matcher.matches()) {
                    strCommand[1].toLowerCase();
                    emailList.add(strCommand[1]);
                } else {
                    System.out.println(WRONG_EMAIL_ANSWER);
                }
            } else if (strCommand[0].equals("LIST")) {
                for (String strEmail : emailList.getSortedEmails()) {
                    System.out.println(strEmail);
                }
            } else {
                System.out.println("Неверно введена команда");
            }
        }
    }
}
