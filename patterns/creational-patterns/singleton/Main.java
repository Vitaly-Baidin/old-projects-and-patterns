public class Main {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance("first");
        Singleton singleton1 = Singleton.getInstance("second");

        System.out.println(singleton.value);
        System.out.println(singleton1.value);

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                SingletonSync singletonSync1 = SingletonSync.getInstance("first");
                System.out.println(singletonSync1.value);
            }).start();
            new Thread(() -> {
                SingletonSync singletonSync2 = SingletonSync.getInstance("second");
                System.out.println(singletonSync2.value);
            }).start();
        }
    }
}
