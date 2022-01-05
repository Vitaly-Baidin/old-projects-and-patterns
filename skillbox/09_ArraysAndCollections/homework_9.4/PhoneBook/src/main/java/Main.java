import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        Scanner scanner = new Scanner(System.in);
        String input;
        Set<String> listTree = null;

        while (true) {
            System.out.println("Введите номер, имя или команду:");
            input = scanner.nextLine();

            if (input.equals("0")) break;

            String[] strCommand = input.split(" ", 2);

            if (strCommand[0].equals("LIST")) {
                for (String elem : listTree) {
                    System.out.println(elem);
                }
                continue;
            }
            if (strCommand[0].matches("((([a-zA-Zа-яА-Я]+)\\s+)?([a-zA-Zа-яА-Я]+))+")) {
                if (phoneBook.getPhoneBook().containsValue(strCommand[0])) {
                    System.out.println(phoneBook.getContactByName(strCommand[0]));
                } else {
                    System.out.println("Такого имени в телефонной книге нет.");
                    System.out.println("Введите номер телефона для абонента \"" + strCommand[0] + "\":");
                    input = scanner.nextLine();
                    phoneBook.addContact(input, strCommand[0]);
                    listTree = phoneBook.getAllContacts();
                    System.out.println("Контакт сохранен!");
                }
            } else if (strCommand[0].matches("(^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$)")) {
                if (phoneBook.getPhoneBook().containsKey(strCommand[0])) {
                    System.out.println(phoneBook.getContactByPhone(strCommand[0]));
                } else {
                    System.out.println("Такого номера нет в телефонной книге.");
                    System.out.println("Введите имя абонента для номера \"" + strCommand[0] + "\":");
                    input = scanner.nextLine();
                    phoneBook.addContact(strCommand[0], input);
                    listTree = phoneBook.getAllContacts();
                    System.out.println("Контакт сохранен!");
                }
            } else {
                System.out.println("Неверный формат ввода");
            }

        }
    }
}
