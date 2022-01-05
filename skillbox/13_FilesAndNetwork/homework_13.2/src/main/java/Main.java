import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Введите исходную директорию, которую копируем: ");
            String sourceDirectory = scanner.nextLine();
            if ( sourceDirectory.equals("0")) {
                break;
            }
            System.out.println("Введите новую директорию, куда копируем: ");
            String destinationDirectory = scanner.nextLine();

            FileUtils.copyFolder(sourceDirectory, destinationDirectory);

        }
    }
}
