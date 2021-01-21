package site.bulibucai.lazy;

/**
 * 基于 DCL，即双重检查锁机制实现的懒汉式单例模式。
 */
public class DclTickGenerator {

    private static DclTickGenerator singleton;

    private DclTickGenerator() {
    }

    public static DclTickGenerator getInstance() {
        if (singleton == null) {
            synchronized (DclTickGenerator.class) {
                if (singleton == null) {
                    //下面一行代码，从字节码的角度来看，并非原子性操作。可能会发生指令重排。
                    //在这里，指令重排虽然不会导致多次创建对象，但是可能会发生堆中的对象内存空间还未进行 <init> 就被引用的情况。
                    singleton = new DclTickGenerator();
                }
            }
        }
        return singleton;
    }
}
