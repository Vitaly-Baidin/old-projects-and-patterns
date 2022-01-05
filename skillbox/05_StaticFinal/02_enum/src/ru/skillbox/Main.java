package ru.skillbox;

public class Main {

    public static void main(String[] args) {
        ArithmeticCalculator num = new ArithmeticCalculator(3, 4);

        num.calculate(Operation.SUBTRACT);
    }
}
