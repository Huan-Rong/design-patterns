package site.bulibucai.lazy;

/**
 * 线程安全的懒汉式单例模式实现。
 * <p>
 * 通过隐式同步锁 synchronized 的方式解决了线程安全问题，但会带来性能问题。
 */
public class SynchronizedTickGenerator {

    private static SynchronizedTickGenerator singleton;

    private SynchronizedTickGenerator() {
    }

    public static synchronized SynchronizedTickGenerator getInstance() {
        if (singleton == null) {
            singleton = new SynchronizedTickGenerator();
        }
        return singleton;
    }
}
