package ru.skillbox;

public class ArithmeticCalculator {
    public static int x;
    public static int y;

    public ArithmeticCalculator(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void calculate(Operation operation) {
        if (operation == Operation.valueOf("ADD")) {
            System.out.println(x + y);
        } else if (operation == Operation.valueOf("SUBTRACT")) {
            System.out.println(x - y);
        } else {
            System.out.println(x * y);
        }
    }
}
