package site.bulibucai.inner;

/**
 * 基于静态内部类实现的懒汉式单例模式
 */
public class StaticInnerTickGenerator {

    private StaticInnerTickGenerator() {
    }

    public static StaticInnerTickGenerator getInstance() {
        return Inner.SINGLETON;
    }

    private static class Inner {
        private static final StaticInnerTickGenerator SINGLETON = new StaticInnerTickGenerator();
    }
}
