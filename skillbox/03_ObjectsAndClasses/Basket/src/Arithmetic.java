public class Arithmetic {
    private int number1;
    private int number2;

    public Arithmetic(int number1, int number2) {
        this.number1 = number1;
        this.number2 = number2;
    }

    public int sumNumbers(int number1, int number2) {
        return number1 + number2;
    }

    public int mulNumbers(int number1, int number2) {
        return number1 * number2;
    }

    public int maxNumbers(int number1, int number2) {
        return number1 > number2 ? number1 : number2;
    }

    public int minNumbers(int number1, int number2) {
        return number1 < number2 ? number1 : number2;
    }
}
