# 单例

一般由五种表示方法：懒汉，双重校验锁，饿汉，枚举和静态内部类

/**
 * @program:
 * @description: 饿汉单例
 **/
public class Singleton {
    private Singleton(){

    }
    private static Singleton instance = new Singleton();

    public static Singleton getInstance(){
        return instance;
    }

}

/**
 * @program:
 * @description: 懒汉单例
 **/
public class Singleton {
    private Singleton(){

    }
    private static Singleton instance;

    public static synchronized Singleton getInstance(){
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}

/**
 * @program:
 * @description: 双重锁单例,防止重复实例化
 **/
public class Singleton {
    private Singleton(){

    }
    private static volatile Singleton instance = new Singleton();

    public static Singleton getInstance(){
        if (instance == null) {
            synchronized (Singleton.class){
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}

/**
 * @program:
 * @description: 内部静态类单例，利用类加载机制
 **/
public class Singleton {

    private Singleton(){

    }

    public static synchronized Singleton getInstance(){
        return SingletonInternal.INSTANCE;
    }
    private static class SingletonInternal{
        private static final Singleton INSTANCE = new Singleton();
    }

}

/**
 * @program:
 * @description: 枚举单例，利用枚举特性
 **/
public enum Singleton {

    INSTANCE;

    public String doMethod() {
        Singleton.INSTANCE.doMethod();
        return "doMethod";
    }
    
    public String doMethod1() {
        Singleton.INSTANCE.doMethod1();
        return "doMethod1";
    }
}
