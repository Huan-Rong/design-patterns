package site.bulibucai.lazy;

/**
 * 同步代码块实现的懒汉式单例模式，线程不安全。
 */
public class SynchronizedBlockTickGenerator {

    private static SynchronizedBlockTickGenerator singleton;

    private SynchronizedBlockTickGenerator() {
    }

    public static SynchronizedBlockTickGenerator getInstance() {
        if (singleton == null) {
            synchronized (SynchronizedBlockTickGenerator.class) {
                singleton = new SynchronizedBlockTickGenerator();
            }
        }
        return singleton;
    }
}
