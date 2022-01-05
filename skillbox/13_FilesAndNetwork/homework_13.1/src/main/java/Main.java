import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double sizeAllFiles;

        while (true) {
            String input = scanner.nextLine();
            if ( input.equals("0")) {
                break;
            }

            sizeAllFiles = FileUtils.calculateFolderSize(input);

            if (sizeAllFiles >= Math.pow(1024, 3)) {
                System.out.printf("%.2f GB",sizeAllFiles / Math.pow(1024, 3));
            } else if (sizeAllFiles >= Math.pow(1024, 2)) {
                System.out.printf("%.2f MB",sizeAllFiles / Math.pow(1024, 2));
            } else if (sizeAllFiles >= 1024) {
                System.out.printf("%.2f KB",sizeAllFiles / 1024);
            } else {
                System.out.printf("%.2f B",sizeAllFiles);
            }
        }
    }
}
