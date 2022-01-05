import java.util.Scanner;

public class Main {

    public static final int BOXES_IN_CONTAINER = 27;
    public static final int BOXES_IN_TRUCK = 324;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String boxes = scanner.nextLine();

        int boxesCount = Integer.parseInt(boxes);
        int containerCount = 0;
        int truckCount = 0;

        for (int i = 1; i <= boxesCount; i++) {
            if (i == 1 || i % BOXES_IN_TRUCK == 1) {
                truckCount++;
                System.out.println("Грузовик: " + truckCount);
            }
            if(i == 1 || i % BOXES_IN_CONTAINER == 1) {
                containerCount++;
                System.out.println("\tКонтейнер: " + containerCount);
            }
            System.out.println("\t\tЯщик: " + i);
        }

        System.out.println("Необходимо:");
        System.out.println("грузовиков - " + truckCount + " шт.");
        System.out.println("контейнеров - " + containerCount + " шт.");

        // TODO: вывести в консоль коробки разложенные по грузовикам и контейнерам
        // пример вывода при вводе 2
        // для отступа используйте табуляцию - \t

        /*
        Грузовик: 1
            Контейнер: 1
                Ящик: 1
                Ящик: 2
        Необходимо:
        грузовиков - 1 шт.
        контейнеров - 1 шт.
        */
    }

}
