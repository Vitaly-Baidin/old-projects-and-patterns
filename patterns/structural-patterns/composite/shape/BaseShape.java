package shape;

public abstract class BaseShape implements Shape {

    private int width;
    private int height;

    public BaseShape(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public int getSquare() {
        return width * height;
    }

    @Override
    public void draw() {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                System.out.println("*\t");
            }
            System.out.println();
        }
    }

    @Override
    public String toString() {
        return "BaseShape{" +
                "width=" + width +
                ", height=" + height +
                '}';
    }
}
