import shape.CompoundShape;
import shape.Rectangle;
import shape.Shape;
import shape.Square;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        CompoundShape compoundShape = new CompoundShape();
        for (int i = 0; i < 5; i++) {
            compoundShape.add(new Square(random.nextInt(5) + 1));
        }
        for (int i = 0; i < 2; i++) {
            compoundShape.add(new Rectangle(random.nextInt(5) + 1, random.nextInt(5) + 1));
        }
        for (Shape shape : compoundShape.getChildren()) {
            System.out.println(shape);
        }
        System.out.println(compoundShape.sumSquare());
    }
}
