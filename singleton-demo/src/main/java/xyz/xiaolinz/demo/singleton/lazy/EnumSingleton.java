package xyz.xiaolinz.demo.singleton.lazy;

import java.util.concurrent.atomic.AtomicLong;

/**
 *
 * 枚举类可以解决懒汉式单例的线程安全问题,主要利用了 Java 类加载机制的特点:
 *  1. 枚举类没有构造方法,因此无法通过反射机制来创建枚举对象
 *  2. 枚举类的构造方法默认使用 private 修饰,因此无法在外部创建枚举对象
 *  3. 枚举类是 final 修饰的,因此无法被继承
 *  4. 枚举类的成员变量都是 final 修饰的,因此无法被修改
 *
 *  本质上就是一个 static final 修饰的对象
 *
 * @author huangmuhong
 * @version 1.0.0
 * @date 2023/7/25
 */
public enum EnumSingleton {
  // static final EnumSingleton SPRING = new EnumSingleton();
  INSTANCE;

  private final AtomicLong atomicLong = new AtomicLong(0);

  public long getNumber() {
    return atomicLong.incrementAndGet();
  }
}
