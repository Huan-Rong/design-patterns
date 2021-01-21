package site.bulibucai.hungry;

/**
 * 基于静态代码块实现单例模式
 */
public class SessionFactory {

    private static final SessionFactory SINGLETON;

    static {
        SINGLETON = new SessionFactory();
    }

    private SessionFactory() {
    }

    public static SessionFactory getInstance() {
        return SINGLETON;
    }
}
