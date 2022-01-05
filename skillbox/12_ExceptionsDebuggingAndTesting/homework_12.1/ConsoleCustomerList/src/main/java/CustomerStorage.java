import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CustomerStorage {
    private final Map<String, Customer> storage;

    public CustomerStorage() {
        storage = new HashMap<>();
    }

    public void addCustomer(String data) throws CustomerStorageException {
        final int INDEX_NAME = 0;
        final int INDEX_SURNAME = 1;
        final int INDEX_EMAIL = 2;
        final int INDEX_PHONE = 3;

        String[] components = data.split("\\s+");

        boolean correctFullName = !(components[INDEX_NAME].matches("[A-Za-zА-Яа-я]*") && components[1].matches("[A-Za-zА-Яа-я]*"));
        boolean correctEmail = !components[2].matches("^[a-zA-Z0-9_.-]+@[a-zA-Z0-9.-]+$");
        boolean correctPhone = !((components[3].length() == 11) || components[3].matches("[+]?[7-8]+[0-9]+"));

        if (components.length != 4) {
            throw new CustomerStorageException("Wrong format. Correct format:\n" + "add Василий Петров " +
                    "vasily.petrov@gmail.com +79215637722", Arrays.toString(components));
        } else if (correctFullName) { // Validate FullName
            throw new CustomerStorageException("Wrong format. Correct format:\n" + "add Василий Петров " +
                    "vasily.petrov@gmail.com +79215637722", Arrays.toString(components));
        } else if (correctEmail) { // validate email
            throw new CustomerStorageException("Wrong format. Correct format:\n" + "add Василий Петров " +
                    "vasily.petrov@gmail.com +79215637722", Arrays.toString(components));
        } else if (correctPhone) { // validate phone
            throw new CustomerStorageException("Wrong format. Correct format:\n" + "add Василий Петров " +
                    "vasily.petrov@gmail.com +79215637722", Arrays.toString(components));
        } else {
            String name = components[INDEX_NAME] + " " + components[INDEX_SURNAME];
            storage.put(name, new Customer(name, components[INDEX_PHONE], components[INDEX_EMAIL]));
        }
    }

    public void listCustomers() {
        storage.values().forEach(System.out::println);
    }

    public void removeCustomer(String name) {
        storage.remove(name);
    }

    public Customer getCustomer(String name) {
        return storage.get(name);
    }

    public int getCount() {
        return storage.size();
    }
}