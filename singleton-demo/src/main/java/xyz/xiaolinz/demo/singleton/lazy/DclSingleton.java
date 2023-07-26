package xyz.xiaolinz.demo.singleton.lazy;


import java.io.*;

/**
 * 双重检查锁定
 * 优点：
 * 1. 懒加载，节省内存，不会在类加载时就创建对象
 * 2. 线程安全
 * 缺点：
 * 1. 代码复杂
 * 2. 可读性差
 *
 * @author huangmuhong
 * @version 1.0.0
 * @date 2023/7/25
 */
public class DclSingleton implements Serializable {

  @Serial private static final long serialVersionUID = 1360140138894765149L;
  /**
   * volatile关键字作用
   * 1. 保证可见性
   * 2. 禁止指令重排
   * 3. 不保证原子性
   * 4. 不能保证有序性
   * 5. 不能替代锁
   *
   * 在 jdk1.5 以后，JVM 内部处理了有序性
   */
  private static volatile DclSingleton instance;

  private DclSingleton() {
    // 防止反射破坏单例
    if (instance != null) {
      throw new RuntimeException("单例模式不允许多个实例");
    }
  }

  // 创建对象不是原子操作，可能会发生指令重排，导致 instance != null 但是对象还没有初始化完成，其他线程获取到的对象是不完整的，使用 volatile 关键字可以禁止指令重排
  public static DclSingleton getInstance() {
    if (instance == null) {
      synchronized (DclSingleton.class) {
        if (instance == null) {
          instance = new DclSingleton();
        }
      }
    }
    return instance;
  }

  /**
   * 用于替换反序列化过程中创建新对象
   * 该方法在反序列化时会被调用，如果该方法存在则直接返回该方法的返回值，而不会拷贝对象
   *
   */
  public Object readResolve() {
    return instance;
  }

}
