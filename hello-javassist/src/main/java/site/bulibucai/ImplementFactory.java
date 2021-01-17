package site.bulibucai;

import javassist.*;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.stream.Collectors;

public class ImplementFactory {

    /**
     * 创建并实例化接口 NonImplementInterface 的实现类。
     * <p>
     * 缺点：接口类型、接口方法的实现逻辑、接口方法名都是强耦合。
     */
    public static NonImplementInterface createImplement() throws Exception {
        ClassPool classPool = ClassPool.getDefault();
        //0.设置 ClassLoader
        classPool.appendSystemPath();
        //1.创建一个 CtClass 类
        CtClass nonImplementInterfaceProxy = classPool.makeClass("NonImplementInterfaceImpl");
        //2.添加一个接口
        nonImplementInterfaceProxy.addInterface(classPool.get(NonImplementInterface.class.getName()));
        //3.创建并添加接口的方法
        CtMethod hello = CtNewMethod.make(CtClass.voidType, "hello",
                new CtClass[]{classPool.get(String.class.getName())},
                new CtClass[0], "{System.out.println(\"hello:\" + $1);}", nonImplementInterfaceProxy);
        nonImplementInterfaceProxy.addMethod(hello);
        //4.动态生成 JVM Class，并通过反射实例化
        Class<NonImplementInterface> proxyInJava = classPool.toClass(nonImplementInterfaceProxy);
        return proxyInJava.newInstance();
    }

    /**
     * 创建并实例化接口 NonImplementInterface 的实现类。
     * <p>
     * 改进：接口类型和接口方法的实现逻辑都通过参数传入。
     * 缺点：方法名仍然是强耦合，接口方法实现逻辑的传入不够优雅。
     */
    public static <T> T createImplement2(Class<T> classInterface, String src) throws Exception {
        ClassPool classPool = ClassPool.getDefault();
        //0.设置 ClassLoader
        classPool.appendSystemPath();
        //1.创建一个 CtClass 类
        CtClass nonImplementInterfaceProxy = classPool.makeClass("NonImplementInterfaceImpl2");
        //2.添加一个接口
        nonImplementInterfaceProxy.addInterface(classPool.get(classInterface.getName()));
        //3.创建并添加接口的方法
        CtMethod hello = CtNewMethod.make(CtClass.voidType, "hello",
                new CtClass[]{classPool.get(String.class.getName())},
                new CtClass[0], src, nonImplementInterfaceProxy);
        nonImplementInterfaceProxy.addMethod(hello);
        //4.动态生成 JVM Class，并通过反射实例化
        Class<T> proxyInJava = classPool.toClass(nonImplementInterfaceProxy);
        return proxyInJava.newInstance();
    }

    /**
     * 改进：支持任意接口、传入接口方法实现逻辑的方式足够优雅
     * 缺点：仅仅是一种接口实现，而没有实现代理设计模式
     */
    public static <T> T createImplement3(Class<T> classInterface, InvocationHandler invocationHandler) throws Exception {
        //1.创建一个 CtClass 类
        ClassPool classPool = ClassPool.getDefault();
        classPool.appendSystemPath();
        CtClass ctClass = classPool.makeClass(classInterface.getName() + "$Proxy");
        //2.添加 invocationHandler 属性
        CtField handlerField = CtField.make("public site.bulibucai.InvocationHandler handler=null;", ctClass);
        ctClass.addField(handlerField);
        //2.添加接口
        ctClass.addInterface(classPool.get(classInterface.getName()));
        //3.实现并添加接口的使用方法
        for (Method method : classInterface.getMethods()) {
            //准备创建方法所需要的属性
            CtClass returnType = classPool.get(method.getReturnType().getName());
            String methodName = method.getName();
            CtClass[] parameters = toCtClass(classPool, method.getParameterTypes());
            CtClass[] exceptions = toCtClass(classPool, method.getExceptionTypes());
            String src = "return ($r) this.handler.invoke(\"%s\", $args);";
            if (method.getReturnType().equals(Void.class)) {
                src = "this.handler.invoke(\"%s\", $args);";
            }
            //创建方法
            CtMethod ctMethod = CtNewMethod.make(returnType, methodName, parameters, exceptions,
                    String.format(src, methodName), ctClass);
            ctClass.addMethod(ctMethod);
        }
        //4.创建 JVM Class 并加载到当前 ClassLoader，之后通过反射实例化
        Class<T> jvmClass = classPool.toClass(ctClass);
        T instance = jvmClass.newInstance();
        //5.设置 handler 属性值
        jvmClass.getField("handler").set(instance, invocationHandler);
        return instance;
    }

    private static CtClass[] toCtClass(ClassPool classPool, Class<?>[] classes) {
        return Arrays.stream(classes).map(c -> {
            try {
                return classPool.get(c.getName());
            } catch (NotFoundException e) {
                throw new RuntimeException(e);
            }
        }).collect(Collectors.toList()).toArray(new CtClass[0]);
    }

}
