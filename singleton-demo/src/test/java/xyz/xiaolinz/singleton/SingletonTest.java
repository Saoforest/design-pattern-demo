package xyz.xiaolinz.singleton;

import static junit.framework.TestCase.*;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import org.junit.Test;
import org.slf4j.Logger;
import xyz.xiaolinz.demo.singleton.hungry.HungrySingletonDemo1;
import xyz.xiaolinz.demo.singleton.lazy.DclSingleton;
import xyz.xiaolinz.demo.singleton.lazy.EnumSingleton;
import xyz.xiaolinz.demo.singleton.lazy.InnerSingleton;

/**
 * @author huangmuhong
 * @version 1.0.0
 * @date 2023/7/25
 */
public class SingletonTest {

  private final Logger logger = org.slf4j.LoggerFactory.getLogger(SingletonTest.class);

  @Test
  public void hungrySingletonDemo1() {
    // 1. 饿汉式单例
    // 1.1. 静态常量饿汉式
    assertSame(HungrySingletonDemo1.getInstance(), HungrySingletonDemo1.getInstance());
  }

  @Test
  public void hungrySingleton() {
    // 1. 饿汉式单例
    // 1.1. 静态常量饿汉式
    assertSame(HungrySingletonDemo1.getInstance(), HungrySingletonDemo1.getInstance());
    // 1.2. 双重检查锁定饿汉式
    assertSame(DclSingleton.getInstance(), DclSingleton.getInstance());
    // 1.3. 内部类饿汉式
    assertSame(InnerSingleton.getInstance(), InnerSingleton.getInstance());
    // 1.4. 枚举类饿汉式
    assertSame(EnumSingleton.INSTANCE, EnumSingleton.INSTANCE);

  }

  /**
   * 反射入侵单例
   *
   */
  @Test
  public void reflectionIntrusionSingleton() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
    final Class<DclSingleton> singletonClass = DclSingleton.class;
    final Constructor<DclSingleton> declaredConstructor = singletonClass.getDeclaredConstructor();
    declaredConstructor.setAccessible(true);

    assertSame(DclSingleton.getInstance(), declaredConstructor.newInstance());
    
  }

  @Test
  public void serializationViolationSingleton() throws IOException, ClassNotFoundException {
    final DclSingleton singleton = DclSingleton.getInstance();

    final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();


    final ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
    objectOutputStream.writeObject(singleton);
    objectOutputStream.flush();

    final ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
    final ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
    final DclSingleton singleton1 = (DclSingleton) objectInputStream.readObject();

    assertSame(singleton, singleton1);


  }
}
