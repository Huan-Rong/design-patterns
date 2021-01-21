package site.bulibucai.lazy;

/**
 * 基于 DCL 和 volatile 实现的懒汉式单例模式，线程安全。
 */
public class DclAndVolatileTickGenerator {

    //避免指令重排
    private static volatile DclAndVolatileTickGenerator singleton;

    private DclAndVolatileTickGenerator() {
    }

    public static DclAndVolatileTickGenerator getInstance() {
        if (singleton == null) {
            synchronized (DclAndVolatileTickGenerator.class) {
                if (singleton == null) {
                    singleton = new DclAndVolatileTickGenerator();
                }
            }
        }
        return singleton;
    }
}
