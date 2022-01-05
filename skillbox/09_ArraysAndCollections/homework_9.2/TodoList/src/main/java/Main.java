import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private static TodoList todoList = new TodoList();

    public static void main(String[] args) {
        // TODO: написать консольное приложение для работы со списком дел todoList
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            String[] strCommand = input.split(" ", 2);
            Pattern pattern = Pattern.compile("\\s?[0-9]+\\s+"); // = Pattern.compile()
            Matcher matcher = pattern.matcher(strCommand[1]);; // = pattern.matcher()
            if (strCommand[0].equals("ADD") && strCommand.length > 1) {
                if (matcher.find()) {
                    strCommand = input.split(" ", 3);
                    todoList.add(Integer.parseInt(strCommand[1]), strCommand[2]);
                    System.out.println("Добавлено дело \"" + strCommand[2] + "\" на место " + (Integer.parseInt(strCommand[1])));
                } else {
                    todoList.add(strCommand[1]);
                    System.out.println("Добавлено дело \"" + strCommand[1] + "\"");
                }
            } else if (strCommand[0].equals("EDIT") && strCommand.length > 1) {
                strCommand = input.split(" ", 3);
                if (matcher.find() && Integer.parseInt(strCommand[1]) < todoList.getTodos().size()) {
                    System.out.println("Дело \"" + todoList.getTodos().get(Integer.parseInt(strCommand[1])) + "\" заменено на \"" + strCommand[2] + "\"");
                    todoList.edit(strCommand[2], Integer.parseInt(strCommand[1]));
                } else {
                    System.out.println("Дело с таким номером не существует");
                }
            } else if (strCommand[0].equals("DELETE") && strCommand.length > 1) {
                strCommand = input.split(" ", 3);
                if (matcher.find() && Integer.parseInt(strCommand[1]) < todoList.getTodos().size()) {
                    System.out.println("Дело \"" + todoList.getTodos().get(Integer.parseInt(strCommand[1])) + "\" удалено");
                    todoList.delete(Integer.parseInt(strCommand[1]));
                } else {
                    System.out.println("Дело с таким номером не существует");
                }
            } else if (strCommand[0].equals("LIST")) {
                for (int i = 0; i < todoList.getTodos().size(); i++) {
                    System.out.println(i + " - " + todoList.getTodos().get(i));
                }
            } else {
                System.out.println("Не правильно введена команда");
            }
        }

    }
}
