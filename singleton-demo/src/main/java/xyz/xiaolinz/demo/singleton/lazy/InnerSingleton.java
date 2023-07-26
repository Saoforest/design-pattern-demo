package xyz.xiaolinz.demo.singleton.lazy;
/**
 *
 * 静态内部类可以解决懒汉式单例的线程安全问题,主要利用了 Java 类加载机制的特点:
 *
 * 静态内部类只有在首次被引用时,才会触发加载和初始化过程。
 * 静态内部类与外部类之间没有实例依赖关系,不会引用外部类的实例。
 * JVM 在加载类时具有同步加锁的机制,可以保证多个线程对同一个类的初始化只会发生一次。
 * 
 * @author huangmuhong
 * @version 1.0.0
 * @date 2023/7/25
 */
public class InnerSingleton {

  // 私有化构造器
  private InnerSingleton() {}

  // 提供方法获取单例对象
  public static InnerSingleton getInstance() {
    return InnerSingletonHolder.instance;
  }



  // 静态内部类只有在首次被引用时,才会触发加载和初始化过程。
  // 实例会在类加载时初始化,并且类加载过程是线程安全的
  private static class InnerSingletonHolder {
    private static final InnerSingleton instance = new InnerSingleton();
  }

}
