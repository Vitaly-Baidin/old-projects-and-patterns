import color.GreenColor;
import shape.Square;

public class Main {
    public static void main(String[] args) {
        Square square = new Square(4, new GreenColor());
        square.draw();
    }
}
