public class Client extends Person {
    @Override
    public void say(String text) {
        System.out.println(text);
    }

    @Override
    public void move() {
        System.out.println("Move it");
    }
}
