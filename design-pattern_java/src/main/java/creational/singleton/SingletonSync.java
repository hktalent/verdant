package creational.singleton;

/**
 * Created by verdant on 2016/1/13.
 * 线程安全：同步块（同时添加了个引用计数，用以回收）
 */
public class SingletonSync {
    private static SingletonSync instance;
    private static int count = 0;

    private SingletonSync() {
    }

    public static SingletonSync getInstance() {
        synchronized (SingletonSync.class) {
            if (instance == null)
                instance = new SingletonSync();
            count++;
        }
        return instance;
    }

    public static void destroy() {
        synchronized (SingletonSync.class) {
            if (count > 1) {
                count--;
                return;
            }
            if (instance != null)
                instance = null;
        }
    }

    public static void main(String[] args) {
        SingletonSync instance = SingletonSync.getInstance();
        SingletonSync instance2 = SingletonSync.getInstance();
        System.out.println(instance == instance2);
        SingletonSync.destroy();
        System.out.println(instance == instance2);
        SingletonSync.destroy();
        System.out.println(instance == null);
    }
}