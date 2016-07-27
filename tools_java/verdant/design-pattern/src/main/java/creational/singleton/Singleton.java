package creational.singleton;

import utils.DebugLog;
import utils.DebugLogFactory;
import utils.DesignPatternEnum;

/**
 * 单例模式
 * 线程安全通过静态内部类（保证只在加载的时候执行一次）
 *
 * @author verdant
 * @since 2016/07/27
 */
public class Singleton {

    private static final DebugLog logger = DebugLogFactory.getLogger(Singleton.class, DesignPatternEnum.Singleton);

    private Singleton() {
    }

    private static class Initializer {
        private static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstance() {
        return Initializer.INSTANCE;
    }

    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        logger.log(instance == instance2 ? "Instance same" : "False");
    }
}