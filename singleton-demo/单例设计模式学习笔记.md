单例模式 (Singleton Pattern)是一种常用的设计模式, 它的目的是确保某一个类只有一个实例, 而且自行实例化并向整个系统提供这个实例。

单例模式的实现步骤:

构造函数为私有 (private), 外界不能直接创建对象
在类内部创建一个静态私有对象
提供一个公有的静态方法, 用于获取这个私有对象
如果对象未初始化, 则先初始化再返回

单例模式的主要优点:

在内存中只有一个实例, 减少了内存开销
避免对资源的多重占用
设置全局访问点, 严格控制访问
单例模式的主要缺点:

没有抽象层, 扩展困难
单例类职责过重, 不符合单一职责原则
某些场景下需要多实例
总体来说, 单例模式可以有效地节省内存空间, 在需要频繁创建销毁的对象时, 可以考虑使用单例模式。但不可滥用, 一定要在适当的场景下使用。

## 单例模式的主要优点 

### 表示全局唯一
如果有些数据在系统中应该且只能保存一份，那就应该设计为单例类。如：

配置类：在系统中，我们只有一个配置文件，当配置文件被加载到内存之后，应该被映射为一个唯一的【配置实例】，此时就可以使用单例，当然也可以不用。
全局计数器：我们使用一个全局的计数器进行数据统计、生成全局递增 ID 等功能。若计数器不唯一，很有可能产生统计无效，ID 重复等。

```java
public class GlobalCounter {
    private AtomicLong atomicLong = new AtomicLong (0);
    private static final GlobalCounter instance = new GlobalCounter ();
    // 私有化无参构造器
    private GlobalCounter () {}
    public static GlobalCounter getInstance () {
        return instance;
    }
    public long getId () { 
        return atomicLong.incrementAndGet ();
    }
}
// 查看当前的统计数量
long courrentNumber = GlobalCounter.getInstance (). getId ();
```
以上代码也可以实现全局 ID 生成器的代码。

### 2. 处理资源访问冲突
如果让我们设计一个日志输出的功能，你不要跟我杠，即使市面存在很多的日志框架，我们也要自己设计。

如下，我们写了简单的小例子：

```java
public class Logger {
    private String basePath = "D://info. log";

    private FileWriter writer;
    public Logger() {
        File file = new File(basePath);
        try {
            writer = new FileWriter(file, true); //true表示追加写入
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void log(String message) {
        try {
            writer.write(message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void setBasePath(String basePath) {
        this.basePath = basePath;
    }
}
```
当然，任何的设计都不是拍脑门，这是我们写的 v 1 版本，他很可能会存在很多的 bug，设计结束之后，我们可能是这样使用的：


```java
@RestController ("user")
public class UserController {

    public Result login(){
        // 登录成功
        Logger logger = new Logger();
        logger.log("tom logged in successfully.");
        
        // ...
        return new Result();
    }
}
```

当然，其他千千万的代码，我们都是这样写的。这样就会产生如下的问题：多个 logger 实例，在多个线程中，同时操作同一个文件，就可能产生相互覆盖的问题。因为 tomcat 处理每一个请求都会使用一个新的线程（暂且不考虑多路复用）。此时日志文件就成了一个共享资源，但凡是多线程访问共享资源，我们都要考虑并发修改产生的问题。

有的同学可能想到如下的解决方案，加锁呀，代码如下：

```java
public synchronized void log (String message) {
    try {
        writer.write (message);
    } catch (IOException e) {
        throw new RuntimeException (e);
    }
}
```

事实上这样加锁毫无卵用，方法级别的锁可以保证 new 出来的同一个实例多线程下可以同步执行 log 方法，然而你却 new 了很多：

![image.png](https://raw.githubusercontent.com/Saoforest/img-storage/master/2023/07/26/12-53-49-b9b546a97e1079ac27b79f0e960b83f6-20230726125348-18311.png)



其实，writer 方法本身也是加了锁的，我们这样加锁就没有了意义：
```java
public void write (String str, int off, int len) throws IOException {
    synchronized (lock) {
        char cbuf[];
        if (len <= WRITE_BUFFER_SIZE) {
            if (writeBuffer == null) {
                writeBuffer = new char[WRITE_BUFFER_SIZE];
            }
            cbuf = writeBuffer;
        } else {    // Don't permanently allocate very large buffers.
            cbuf = new char[len];
        }
        str.getChars (off, (off + len), cbuf, 0);
        write (cbuf, 0, len);
    }
}
```

当然，加锁是一定能解决共享资源冲突问题的，我们只要放大锁的范围从【this】到【class】，这个问题也是能解决的，代码如下：

![image.png](https://raw.githubusercontent.com/Saoforest/img-storage/master/2023/07/26/12-54-23-bcc4909416683279c1f1cf7dfe1113b2-20230726125423-c52dd.png)


```java
public void log (String message) {
    synchronized (Logger. class) {
        try {
            writer.write (message);
        } catch (IOException e) {
            throw new RuntimeException (e);
        }
    }
}
```
从以上的内容我们也发现了：

如果使用单个实例输出日志，锁【this】即可。
如果要保证 JVM 级别防止日志文件访问冲突，锁【class】即可。
如果要保证集群服务级别的防止日志文件访问冲突，加分布式锁即可。
如果我们是一个简单工程，对日志输入要求不高。单例模式的解决思路就十分合适，既然同一个 Logger 无法并行输出到一个文件中，那么针对这个日志文件创建多个 Logger 实例也就失去了意义，如果工程要求我们所有的日志输出到同一个日志文件中，这样其实并不需要创建大量的 Logger 实例，这样的好处有：

一方面节省内存空间。
另一方面节省系统文件句柄（对于操作系统来说，文件句柄也是一种资源，不能随便浪费）。
按照这个设计思路，我们实现了 Logger 单例类。具体代码如下所示：


```java
public class Logger {
    private String basePath = "D://log/";
    private static Logger instance = new Logger ();
    private FileWriter writer;

    private Logger() {
        File file = new File(basePath);
        try {
            writer = new FileWriter(file, true); //true表示追加写入
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Logger getInstance(){
        return instance;
    }

    public void log(String message) {
        try {
            writer.write(message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void setBasePath(String basePath) {
        this.basePath = basePath;
    }
}
```

除此之外，并发队列（比如 Java 中的 BlockingQueue）也可以解决这个问题：多个线程同时往并发队列里写日志，一个单独的线程负责将并发队列中的数据写入到日志文件。这种方式实现起来也稍微有点复杂。当然，我们还可将其延伸至消息队列处理分布式系统的日志。

## 如何实现一个单例
实现单例的步骤

实现单例模式的一般步骤如下：

1. 创建一个私有的静态成员变量，用于保存单例实例对象。
2. 创建一个私有的构造方法，防止外部直接创建对象。
3. 创建一个公有的静态方法，用于获取单例实例对象。在该方法中，判断静态成员变量是否为空，如果为空则创建一个新的实例对象并赋值给静态成员变量，如果不为空则直接返回静态成员变量。
4. 是否支持懒加载（延迟加载）
5. 是否线程安全

### 饿汉式

饿汉式实现方式简单，在类中提供一个静态实例 `instance` 来在类加载的时候实例化一个唯一实例，而且是通过类加载的方式创建的对象，JVM 保证了现成安全。
```java
package xyz.xiaolinz.demo.singleton.hungry;
/**
 *
 * 创建型设计模式 - 单例模式 - 饿汉式
 * 1. 持有一个 jvm 全局唯一的实例
 * 2. 避免别人随意的创建单例对象，需要私有化构造器
 * 3. 暴露一个方法用于获取全局唯一实例
 *
 * 优点：
 *  1. 创建对象本身的复杂度：很多单例的对象创建过程极其复杂；很多单例对象创建会占用很大内存，比如缓存对象；很多单例对象创建完成后可能很小且简单
 *
 * @author huangmuhong
 * @version 1.0.0
 * @date 2023/7/25
 */
public class HungrySingletonDemo1 {

  // idea 1
  private static final HungrySingletonDemo1 instance = new HungrySingletonDemo1();


  // idea 2
  private HungrySingletonDemo1() {}


  // idea 3
  public static HungrySingletonDemo1 getInstance() {
    return instance;
  }

}

```

事实上，恶汉式的写法在工作中反而应该被提倡，面试中不问，只是应为他简单。很多人觉得饿汉式不能支持懒加载，即使不使用也会浪费资源，一方面是内存资源，一方面会增加初始化的开销。

1、现代计算机不缺这一个对象的内存。

2、如果一个实例初始化的过程复杂那更加应该放在启动时处理，避免卡顿或者构造问题发生在运行时。满足 fail-fast 的设计原则。

### 懒汉式

懒汉式相对于饿汉式的优势是支持延迟加载，具体实现为
```java
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

```

以上写法本质上是有问题的，当大量并发同时访问 `getInstance` 的时候，可能会造成超过一个线程同时执行了 new LazySingletonDemo1();

我们可以使用简单粗暴的方法，直接给当前 `getInstance()` 方法加上 `synchronized` 关键字加锁即可解决
```java
public class LazySingletonDemo1 {

  private static LazySingletonDemo1 instance;

  private LazySingletonDemo1() {}


  // TODO 严重影响xingneng
  public static synchronized LazySingletonDemo1 getInstance() {
    if (instance == null) {
      instance = new LazySingletonDemo1();
    }
    return instance;
  }

}
```

以上的写法确实可以保证 jvm 中有且仅有一个单例实例存在，但是方法上加锁会极大的降低获取单例对象的并发度。同一时间只有一个线程可以获取单例对象，为了解决以上的方案则有了第三种写法。

#### 懒汉式线程安全 - 双重检查锁
饿汉式不支持延迟加载，懒汉式有性能问题，不支持高并发。那我们再来看一种既支持延迟加载、又支持高并发的单例实现方式，也就是双重检测实现方式：

在这种实现方式中，只要 instance 被创建之后，即便再调用 getInstance () 函数也不会再进入到加锁逻辑中了。所以，这种实现方式解决了懒汉式并发度低的问题。具体的代码实现如下所示：

```java
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

}

```

#### 懒汉式线程安全 - 静态内部类

我们可以利用 JVM 的类加载机制来实现懒汉式的线程安全，有点类似饿汉式，但又能做到了延迟加载。
```java
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

```

这里是利用了 JVM 加载类的特性来实现的，JVM 在类加载时后以下特性
>JVM 在加载外部类的过程中, 是不会加载静态内部类的。只有当调用 getInstance () 方法从而触发 SingletonHolder. INSTANCE 时才会去初始化内部类。
>JVM 在类加载过程中天然地实现了同步, 保证了 INSTANCE 只被实例化一次。
>这样 INSTANCE 在第一次的时候被 indirect 初始化, 同时不会有并发问题。
>通过静态内部类实现的单例是懒加载的, 并且是线程安全的, 所以很好地解决了懒汉式单例的问题。

**这种方式也被称为 Holder 模式,是实现单例的一种很好的实践。**

#### 懒汉式线程安全 - 枚举
基于枚举类型的单例实现。这种实现方式通过 Java 枚举类型本身的特性，保证了实例创建的线程安全性和实例的唯一性。之所以可以使用枚举实现线程安全的懒汉式单例，是使用到了以下两个特性
1. 枚举类的构造函数会被默认设置为私有的, 外部无法直接实例化。
2. 枚举类的实例化是线程安全的。

```java
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

```

## 单例的破坏
单例模式确保系统中一个类只有一个实例, 但是单例仍然可以通过一些手段被破坏:

1. 通过反射破坏
	反射可以直接调用私有构造方法, 破坏了单例。

2. 通过序列化和反序列化破坏
	序列化后再反序列化会重新创建实例。

3. 通过克隆破坏
	克隆对象会新建一个实例。

4. 通过多个类加载器加载破坏
	不同类加载器加载同一个类会产生不同的实例。

要防止这些问题, 可以通过一些手段增强单例:
- 枚举方式天然防止反射攻击。
- 增加 readResolve ()方法防止反序列化破坏。
- 重写 clone 方法抛出异常防止克隆。
- 单例与类加载器绑定防止多加载器问题。
- 所以在使用单例时, 要注意可能的风险, 通过一定的保护手段来防止单例被破坏。


### 反射破坏单例
在我们上述的例子中，我们通过内部缓存一个私有化的静态实例，并私有化构造方法和提供 getInstance 来获取单例对象，但是我们可以通过反射的方式破坏构造方法的私有性从而创建新的实例，以下是测试代码
```java
  /**
   * 反射入侵单例
   *
   */
  @Test
  public void reflectionIntrusionSingleton() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
    final Class<DclSingleton> singletonClass = DclSingleton.class;
    final Constructor<DclSingleton> declaredConstructor = singletonClass.getDeclaredConstructor();
    declaredConstructor.setAccessible(true);

    assertNotSame(DclSingleton.getInstance(), declaredConstructor.newInstance());
    
  }
```

在上述代码中，我们通过反射获取到了 `DclSingleton` 类的构造方法，并通过设置 `setAccessible` 方法的属性来打破私有化

结果：
![image.png](https://raw.githubusercontent.com/Saoforest/img-storage/master/2023/07/26/13-14-17-a064f6dfcd410c4d5746f9e4c0192a27-20230726131416-11aec.png)
可以看到，反射破坏了我们对单例的封装。

如何解决呢？我们可以在构造方法上做文章，既然单例是反射构造方法取创建新的实例，我们可以在构造方法中判断是否已经存在单例对象了，如果存在单例对象则报错抛出异常
```java
  private DclSingleton() {
    // 防止反射破坏单例
    if (instance != null) {
      throw new RuntimeException("单例模式不允许多个实例");
    }
  }
```

### 序列化破坏单例
反序列化之所以能破坏单例是因为反序列化时默认行为是浅拷贝，当发生拷贝时，会创建一个新的实例从而破坏单例的应用
```java
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
```

结果：
![image.png](https://raw.githubusercontent.com/Saoforest/img-storage/master/2023/07/26/13-18-48-3eefd9cde5d42997a057b25107b152f7-20230726131847-2a9c4.png)
我们可以通过在实例类中添加 readReolve() 方法的方式来解决反序列化对单例的破坏问题
```java
  /**
   * 用于替换反序列化过程中创建新对象
   * 该方法在反序列化时会被调用，如果该方法存在则直接返回该方法的返回值，而不会拷贝对象
   *
   */
  public Object readResolve() {
    return instance;
  }
```

>readResolve () 是 Java 中用于处理序列化和反序列化的一个特殊方法。它的主要作用有:
>在反序列化时替换反序列化出来的对象
>保留序列化对象的状态
>分隔实例