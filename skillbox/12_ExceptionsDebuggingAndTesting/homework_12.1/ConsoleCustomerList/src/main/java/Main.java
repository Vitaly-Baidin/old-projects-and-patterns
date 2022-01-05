import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static final String ADD_COMMAND = "add Василий Петров " +
            "vasily.petrov@gmail.com +79215637722";
    private static final String COMMAND_EXAMPLES = "\t" + ADD_COMMAND + "\n" +
            "\tlist\n\tcount\n\tremove Василий Петров";
    private static final String COMMAND_ERROR = "Wrong command! Available command examples: \n" +
            COMMAND_EXAMPLES;
    private static final String helpText = "Command examples:\n" + COMMAND_EXAMPLES;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CustomerStorage executor = new CustomerStorage();

        while (true) {
            String command = scanner.nextLine();
            String[] tokens = command.split("\\s+", 2);

            if (tokens[0].equals("add")) {
                try {
                    if (tokens.length < 2){
                        throw new CustomerStorageException("Wrong format. Correct format:\n" + "add Василий Петров " +
                                "vasily.petrov@gmail.com +79215637722", Arrays.toString(tokens));
                    } else {
                        executor.addCustomer(tokens[1]);
                    }

                } catch (CustomerStorageException e) {
                    System.out.println(e.getLocalizedMessage());
                }

            } else if (tokens[0].equals("list")) {
                executor.listCustomers();
            } else if (tokens[0].equals("remove")) {
                try {
                    if (tokens.length == 1){
                        throw new CustomerStorageException("Wrong format. Correct format:\n" + "add Василий Петров " +
                                "vasily.petrov@gmail.com +79215637722", Arrays.toString(tokens));
                    } else {
                        executor.removeCustomer(tokens[1]);
                    }

                } catch (CustomerStorageException e) {
                    System.out.println(e.getLocalizedMessage());
                }

            } else if (tokens[0].equals("count")) {
                System.out.println("There are " + executor.getCount() + " customers");
            } else if (tokens[0].equals("help")) {
                System.out.println(helpText);
            } else {
                System.out.println(COMMAND_ERROR);
            }
        }
    }
}
