package site.bulibucai.hungry;

/**
 * 基于静态常量实现单例模式
 */
public class NumberGenerator {

    private static final NumberGenerator SINGLETON = new NumberGenerator();

    private NumberGenerator() {
    }

    public static NumberGenerator getInstance() {
        return SINGLETON;
    }
}
