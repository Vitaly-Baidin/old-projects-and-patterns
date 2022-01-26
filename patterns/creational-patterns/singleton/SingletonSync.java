public class SingletonSync {

    private static volatile SingletonSync instance;
    public String value;

    private SingletonSync(String value) {
        this.value = value;
    }

    public static SingletonSync getInstance(String value) {
        SingletonSync result = instance;
        if (result != null) {
            return result;
        }
        synchronized (SingletonSync.class) {
            if (instance == null) {
                instance = new SingletonSync(value);
            }
            return instance;
        }
    }
}
