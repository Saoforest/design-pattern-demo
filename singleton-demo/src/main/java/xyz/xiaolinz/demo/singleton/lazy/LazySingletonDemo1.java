package xyz.xiaolinz.demo.singleton.lazy;
/**
 *
 * 创建型设计模式 - 单例模式 - 懒汉式
 *
 * 优点：
 * 1. 懒加载，节省内存，不会在类加载时就创建对象
 * 缺点：
 * 1. 线程不安全，多线程环境下可能会创建多个实例
 * 解决方案：
 * 1. 在 getInstance 方法上加锁，但是会影响性能
 * 2. 双重检查锁定，但是在 jdk1.5 之前会有指令重排的问题，需要加 volatile 关键字
 * 3. 静态内部类，利用 jvm 类加载机制，保证线程安全
 * 4. 枚举类，利用 jvm 类加载机制，保证线程安全
 * 5. 使用容器实现单例模式
 *
 * @author huangmuhong
 * @version 1.0.0
 * @date 2023/7/25
 */
public class LazySingletonDemo1 {

  private static LazySingletonDemo1 instance;

  private LazySingletonDemo1() {}


  // TODO 当前实现方式线程不安全
  public static LazySingletonDemo1 getInstance() {
    if (instance == null) {
      instance = new LazySingletonDemo1();
    }
    return instance;
  }

}
