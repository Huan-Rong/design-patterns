package site.bulibucai.lazy;

/**
 * 线程不安全的懒汉式单例模式实现。
 */
public class TickGenerator {
    private static TickGenerator singleton;

    private TickGenerator() {
    }

    /**
     * 分析 getInstance 方法的字节码更容易理解：该方法的实现是线程不安全的。
     */
    public static TickGenerator getInstance() {
        if (singleton == null) {
            singleton = new TickGenerator();
        }
        return singleton;
    }
}
