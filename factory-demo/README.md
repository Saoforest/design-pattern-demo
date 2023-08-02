## 工厂设计模式介绍

工厂设计模式是一种创建型设计模式，它提供了一种创建对象的方式，而不需要显式指定其具体类。工厂设计模式将对象的创建过程封装在一个工厂类中，客户端只需要通过调用工厂类的方法来获取所需的对象。

工厂设计模式主要包含以下几个角色：

1. 抽象产品（Abstract Product）：定义了产品的抽象接口，所有具体产品都必须实现这个接口。

2. 具体产品（Concrete Product）：实现了抽象产品接口定义的方法，是具体的产品对象。

3. 抽象工厂（Abstract Factory）：定义了创建抽象产品的接口，在其中声明了各种创建产品的方法。

4. 具体工厂（Concrete Factory）：实现了抽象工厂中声明的各种创建产品的方法，是具体的工厂对象。

客户端使用工厂设计模式时，首先需要选择一个具体工厂来实例化。然后通过该具体工厂来创建所需的具体产品对象，而无需直接调用具体产品类的构造函数。

优点：
1. 解耦：将客户端与具体产品类解耦，客户端只需要知道使用哪个具体工厂即可。
2. 扩展性：增加新的具体产品和具体工厂非常方便，符合开闭原则。
3. 简化客户端代码：客户端只需要关心具体工厂和抽象产品，而不需要关心具体产品的创建过程。

缺点：
1. 增加了系统复杂度：引入了额外的类和接口，增加了系统的抽象性和理解难度。
2. 不易于维护：每个具体产品都需要对应一个具体工厂，当有多个产品族时，工厂类的数量会增加。

适用场景：
1. 当一个系统要独立于它创建的对象时。
2. 当一个系统需要动态地指定对象的创建时。
3. 当一个系统需要通过组合来表达产品间的依赖关系时。

### 工厂模式的种类
一般情况下，工厂模式分为三种更加细分的类型：简单工厂、工厂方法和抽象工厂。

在 GoF 的《设计模式》一书中，它将简单工厂模式看作是工厂方法模式的一种特例，所以工厂模式只被分成了工厂方法和抽象工厂两类。实际上，前面一种分类方法更加常见，所以，在今天的讲解中，我们沿用第一种分类方法。

在这三种细分的工厂模式中，简单工厂、工厂方法原理比较简单，在实际的项目中也比较常用。而抽象工厂的原理稍微复杂点，在实际的项目中相对也不常用。所以，我们今天讲解的重点是前两种工厂模式。对于抽象工厂，你稍微了解一下即可。

## 如何实现设计模式

###  [[简单工厂模式]] 
简单工厂模式也叫做 `静态工厂模式（Static Factory Method Pattern）`。

场景：我们需要通过 url 来进行资源加载，该 url 有不同的来源格式如 classpath、http、ftp 等。

定义公共常用类
- ResourceLoaderException
```java
package xyz.xiaolinz.demo.factory.simpleFactory;

import java.io.Serial;

/**
 * @author huangmuhong
 * @version 1.0.0
 * @date 2023/7/27
 */
public class ResourceLoaderException extends RuntimeException {

  @Serial private static final long serialVersionUID = -6816983568181761093L;

  public ResourceLoaderException() {
    super("资源加载异常");
  }

  public ResourceLoaderException(String message) {
    super(message);
  }

  public ResourceLoaderException(String message, Throwable cause) {
    super(message, cause);
  }
}

```

- Resource
```java
package xyz.xiaolinz.demo.factory.simpleFactory;

import java.io.Serial;

/**
 * @author huangmuhong
 * @version 1.0.0
 * @date 2023/7/27
 */
public class ResourceLoaderException extends RuntimeException {

  @Serial private static final long serialVersionUID = -6816983568181761093L;

  public ResourceLoaderException() {
    super("资源加载异常");
  }

  public ResourceLoaderException(String message) {
    super(message);
  }

  public ResourceLoaderException(String message, Throwable cause) {
    super(message, cause);
  }
}

```

定义一个 `ResourceFactory` ，他提供了一个静态方法用于创建 `Resource` 对象，需要 url 和 prefix 参数
```java
package xyz.xiaolinz.demo.factory.simpleFactory;
/**
 * 简单工厂 提供一个创建对象实例的功能，而无需关心其具体实现
 *
 * @author huangmuhong
 * @version 1.0.0
 * @date 2023/07/27
 */
public class ResourceFactory {

  public static Resource create(String prefix, String url) {

    // TODO 这里只是模拟，真实场景会经过很多复杂的读取逻辑
    if ("file".equals(prefix)) {
      return new Resource(url);
    } else if ("http".equals(prefix)) {
      return new Resource(url);
    } else if ("ftp".equals(prefix)) {
      return new Resource(url);
    } else if ("classpath".equals(prefix)) {
      return new Resource(url);
    }
    throw new ResourceLoaderException("不支持的资源类型");
  }
}

```
通过该工厂我们可以访问 `create(String prefix, String url)` 方法动态的去创建 Resource 的实例，而无需关注创建 Resource 的实现细节。
我们将【创建资源产品】这个单一的能力赋予产品工厂，这样能更好的符合单一原则。

- ResourceLoader
```java
package xyz.xiaolinz.demo.factory.simpleFactory;
/**
 * 资源加载器
 *
 * @author huangmuhong
 * @version 1.0.0
 * @date 2023/07/27
 */
public class ResourceLoader {

  /**
   * 加载资源
   *
   * @param url URL file://, http://, ftp://,classpath://
   * @return {@link Resource} 资源对象
   */
  public Resource load(String url) {

    // 1.根据 url 获取前缀
    String prefix = getPrefix(url);

    // 2.根据前缀获取资源
    return ResourceFactory.create(prefix, url);
  }

  private String getPrefix(String url) {
    if (url == null || "".equals(url) || !url.contains(":")) {
      // url 为空或者不包含 : 的情况
      throw new ResourceLoaderException();
    }
    return url.trim().split("://")[0];
  }
}

```

简单工厂模式就是提取一个工厂类，该类封装了创建目标对象的具体细节，调用方无需关注对象是如何创建的即可动态的创建目标对象。
将创建对象的过程交给工厂类、其他业务需要某个产品时，直接使用 create（方法名字不重要）创建即可这样的好处是：

1、工厂将创建的过程进行封装，不需要关系创建的细节，更加符合面向对象思想

2、这样主要的业务逻辑不会被创建对象的代码干扰，代码更易阅读

3、产品的创建可以独立测试，更将容易测试

4、独立的工厂类只负责创建产品，更加符合单一原则

#### 简单工厂模式的问题
1. 简单工厂违反开闭原则

简单工厂是一种创建对象的设计模式，它通过一个工厂类来封装对象的创建过程，客户端只需要通过工厂类来获取对象，而不需要关心对象的具体创建细节。然而，简单工厂违反了开闭原则。

开闭原则是面向对象设计中的一个重要原则，它要求软件实体（类、模块、函数等）应该对扩展开放，对修改关闭。简单工厂在新增产品时需要修改工厂类的代码，违反了对修改关闭的原则。

当需要新增一个产品时，简单工厂需要修改工厂类的代码来添加新的判断逻辑，并在其中实例化新产品对象。这样一来，如果以后需要新增更多产品，就需要不断地修改工厂类的代码。这不仅增加了维护成本，还可能引入新的bug。

为了遵循开闭原则，在面对新增产品时应该使用其他设计模式来解决问题。例如，可以使用工厂方法模式或者抽象工厂模式来实现根据需求动态创建对象。这些模式将具体产品的创建延迟到子类中实现，在新增产品时只需要添加新的子类即可，无需修改已有代码。

**但是原则这种东西，一定要结合业务创建，在创建对象的过程相对简单，业务改动不是很频繁的情况下，适当的不按原则出牌才是更好的选择，只是偶尔修改一下 ResourceLoaderFactory 代码，稍微不符合开闭原则，也是完全可以接受的。因为这样可以更加简单的编码，在进行软件开发时编码难度也是一个很重要的考量标准。我们一定要在合理设计和过度设计之间进行权衡，明白一点，适合的才是最好的。**

### 2. 工厂方法模式（Factory Method）

在上述[简单工厂模式]的例子中，我们每次添加新的资源加载方式都要在 if-else 中添加分支，这不仅破坏了开闭原则，在 if 分支过于膨胀的情况下也有变成肿瘤代码的可能。我们可以利用多态。按照多态的实现思路，对上面的代码进行重构。我们会为每一个 Resource 创建一个独立的工厂类，形成一个个小作坊，将每一个实例的创建过程交给工厂类完成。

之前是一个大而全的工厂，工厂内创建了各种各样的商品，工厂方法讲究的就是专而精，一个工厂只创建一种具体的资源。每一种 url 加载成不同的资源产品，这样可以为每一种资源加载模式实现单独的精确工厂，这就是工厂方法模式

- 定义工厂方法接口，提供统一的创建对象方法而不需关心实现细节
```java
package xyz.xiaolinz.demo.factory.methodFactory.factory;

import xyz.xiaolinz.demo.factory.simpleFactory.Resource;

/**
 * 工厂方法, 提供一个创建对象实例的功能，而无需关心其具体实现
 *
 * @author huangmuhong
 * @version 1.0.0
 * @date 2023/08/01
 */
public interface ResourceLoaderFactory {

  /**
   * 资源加载器
   *
   * @param url 地址
   * @return {@link Resource}
   */
  Resource loader(String url);
}

```

- 创建每种 url 的具体实现工厂
```java
package xyz.xiaolinz.demo.factory.methodFactory.factory;

import xyz.xiaolinz.demo.factory.simpleFactory.Resource;

/**
 * http资源加载器
 *
 * @author huangmuhong
 * @version 1.0.0
 * @date 2023/08/01
 */
public class ClassPathResourceLoaderFactory implements ResourceLoaderFactory {

  @Override
  public Resource loader(String url) {
    // 省略复杂的业务创建过程
    return new Resource(url);
  }
}


package xyz.xiaolinz.demo.factory.methodFactory.factory;

import xyz.xiaolinz.demo.factory.simpleFactory.Resource;

/**
 * http资源加载器
 *
 * @author huangmuhong
 * @version 1.0.0
 * @date 2023/08/01
 */
public class HttpResourceLoaderFactory implements ResourceLoaderFactory {

  @Override
  public Resource loader(String url) {
    // 省略复杂的业务创建过程
    return new Resource(url);
  }
}

```

实际上，这就是工厂方法模式的典型代码实现。这样当我们新增一种读取资源的方式时，只需要新增一个实现，并实现 IResourceLoader 接口即可。所以，工厂方法模式比起简单工厂模式更加符合开闭原则。

当然，关是具体生产具体实现还不能解决我们简单工厂的破坏开闭原则的问题，根据案例 1 我们对工厂方法的使用为
```java
package xyz.xiaolinz.demo.factory.methodFactory;

import xyz.xiaolinz.demo.factory.methodFactory.factory.ClassPathResourceLoaderFactory;
import xyz.xiaolinz.demo.factory.methodFactory.factory.HttpResourceLoaderFactory;
import xyz.xiaolinz.demo.factory.methodFactory.factory.ResourceLoaderFactory;
import xyz.xiaolinz.demo.factory.simpleFactory.Resource;
import xyz.xiaolinz.demo.factory.simpleFactory.ResourceLoaderException;

/**
 * @author huangmuhong
 * @version 1.0.0
 * @date 2023/8/1
 */
public class ResourceLoaderVersion1 {

  private ResourceLoaderFactory factory;

  /**
   * 加载资源
   *
   * @param url URL file://, http://, ftp://,classpath://
   * @return {@link Resource} 资源对象
   */
  public Resource load(String url) {

    // 1.根据 url 获取前缀
    String prefix = getPrefix(url);

    if ("classpath".equals(prefix)) {
      factory = new ClassPathResourceLoaderFactory();
    } else if ("http".equals(prefix)) {
      factory = new HttpResourceLoaderFactory();
    }
    // 2.根据前缀获取资源
    return factory.loader(url);
  }

  private String getPrefix(String url) {
    if (url == null || "".equals(url) || !url.contains(":")) {
      // url 为空或者不包含 : 的情况
      throw new ResourceLoaderException();
    }
    return url.trim().split("://")[0];
  }
}

```

在上述代码中，虽然经过工厂方法的抽离和封装后, if-else 的分支逻辑变得极为简单，但是如果当我们的资源加载工厂非常多的时候，还是会造成我们的分支过长过大的问题，所以我们需要通过重构的方式来实现优化。

- 1. 通过提前缓存工厂实例从而去除 if-else 逻辑的判断
```java
private final Map<String, ResourceLoaderFactory> factoryMap = new HashMap<>(10);

  // TODO 符合开闭原则，通过提前缓存工厂实例从而去除了 if-else 分支判断
  {
    factoryMap.put("classpath", new ClassPathResourceLoaderFactory());
    factoryMap.put("http", new HttpResourceLoaderFactory());
  }
```

- 2. 通过读取配置文件优化 if-else 逻辑的判断 

我们可以通过在配置文件中定义 prefix 与 class 的关系从而实现动态的资源工厂加载器的读取，彻底解决开闭原则问题

- resouceLoader.properties
```properties
http=xyz.xiaolinz.demo.factory.methodFactory.factory.HttpResourceLoaderFactory
classpath=xyz.xiaolinz.demo.factory.methodFactory.factory.ClassPathResourceLoaderFactory
```

有了这个配置文件，我们就可以在对象实例化时去动态的读取该文件从而实现工厂的动态缓存

```java
package xyz.xiaolinz.demo.factory.methodFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import xyz.xiaolinz.demo.factory.methodFactory.factory.ResourceLoaderFactory;
import xyz.xiaolinz.demo.factory.simpleFactory.Resource;
import xyz.xiaolinz.demo.factory.simpleFactory.ResourceLoaderException;

/**
 * @author huangmuhong
 * @version 1.0.0
 * @date 2023/8/1
 */
public class ResourceLoaderVersion3 {

  //  private ResourceLoaderFactory factory;

  private final Map<String, ResourceLoaderFactory> factoryMap = new HashMap<>(10);

  // TODO 符合开闭原则，通过配置文件的方式，可以动态的添加新的资源加载器
  {
    final var inputStream =
        Thread.currentThread()
            .getContextClassLoader()
            .getResourceAsStream("resouceLoader.properties");
    final var properties = new Properties();
    try {
      properties.load(inputStream);

      for (Entry<Object, Object> entry : properties.entrySet()) {
        final var key = entry.getKey().toString();
        final var className = entry.getValue().toString();
        final Class<?> classz = Class.forName(className);
        final ResourceLoaderFactory resourceLoaderFactory =
            (ResourceLoaderFactory) classz.getDeclaredConstructor().newInstance();
        factoryMap.put(key, resourceLoaderFactory);
      }
    } catch (Exception e) {
      throw new ResourceLoaderException("加载资源配置文件失败", e);
    }
  }

  /**
   * 加载资源
   *
   * @param url URL file://, http://, ftp://,classpath://
   * @return {@link Resource} 资源对象
   */
  public Resource load(String url) {

    // 1.根据 url 获取前缀
    String prefix = getPrefix(url);

    final var resourceLoaderFactory = factoryMap.get(prefix);

    if (resourceLoaderFactory == null) {
      throw new ResourceLoaderException("不支持的资源类型");
    }

    // 2.根据前缀获取资源
    return resourceLoaderFactory.loader(url);
  }

  private String getPrefix(String url) {
    if (url == null || "".equals(url) || !url.contains(":")) {
      // url 为空或者不包含 : 的情况
      throw new ResourceLoaderException();
    }
    return url.trim().split("://")[0];
  }
}

```

以后我们想新增或删除一个 resourceLoader 只需要写一个类实现 IResourceLoader 接口，并在配置文件中进行配置即可。此时此刻我们已经看不到 if-else 的影子了。

在实际开发中，产品可能不仅仅是一个简单的类，可能有很多的通用方法和模板方法，我们可以提取出一个抽象类定义出所具有的共性和提供模板方法，每个具体的产品都实现具体的产品类。

```java
package xyz.xiaolinz.demo.factory.methodFactory2.product;

import java.io.InputStream;
import lombok.Getter;

/**
 * 产品
 *
 * @author huangmuhong
 * @version 1.0.0
 * @date 2023/08/01
 */
@Getter
public abstract class AbstractResource {

  private String url;

  public AbstractResource() {}

  public AbstractResource(String url) {
    this.url = url;
  }

  protected void shared() {
    System.out.println("公共方法");
  }

  /**
   * 获取输入流
   *
   * @return {@link InputStream}
   */
  public abstract InputStream getInputStream();
}


```

具体产品继承这个抽象类
```java
package xyz.xiaolinz.demo.factory.methodFactory2.product;

import java.io.InputStream;

/**
 * @author huangmuhong
 * @version 1.0.0
 * @date 2023/8/1
 */
public class ClassPathResource extends AbstractResource {

  public ClassPathResource() {}

  public ClassPathResource(String url) {
    super(url);
  }

  @Override
  public InputStream getInputStream() {
    return null;
  }
}

```

```java
package xyz.xiaolinz.demo.factory.methodFactory2.product;

import java.io.InputStream;

/**
 * @author huangmuhong
 * @version 1.0.0
 * @date 2023/8/1
 */
public class HttpResource extends AbstractResource {

  public HttpResource() {}

  public HttpResource(String url) {
    super(url);
  }

  @Override
  public InputStream getInputStream() {
    return null;
  }
}

```


### 抽象工厂（Abstract Factory）

抽象工厂模式（Abstract Factory Pattern），该设计模式的应用场景比较特殊，他的重要性比不上简单工厂和工厂方法，其定义如下：

Provide an interface for creating families of related or dependent objects without specifying their concrete classes. (为创建一组相关或者相互依赖的对象提供一个接口，而且无须指定他们的具体类。)

抽象工厂模式是工厂方法模式的升级版本，在有多个业务品种、业务分类时，通过抽象工厂模式生产需要的对象是一种不错的解决方案。

在简单工厂和工厂方法中，往往只需要创建一种类型的产品，但是如果需求改变，需要增加多种类型的产品，即增加产品族，我们上边的需求是创建各种类型的资源，本小节我们再增加一个维度，如图片资源、视频资源、文本资源等。

如果不停的增加产品维度，最后导致的结果就是产品数量不停的爆炸，以笛卡尔集的方式指数级增长。

1、HttpPictureResource
2、HttpVideoResource
3、ClasspathPictureResource
4、ClasspathVideoResource
......

我们定义图片资源和视频资源维度的 Resource

```java
package xyz.xiaolinz.demo.factory.abstractFactory.product;

import java.io.InputStream;

/**
 * @author huangmuhong
 * @version 1.0.0
 * @date 2023/8/1
 */
public interface Resource {

  /**
   * 获取输入流
   *
   * @return {@link InputStream}
   */
  InputStream getInputStream();
}


package xyz.xiaolinz.demo.factory.abstractFactory.product;

import java.io.InputStream;
import lombok.Getter;

/**
 * @author huangmuhong
 * @version 1.0.0
 * @date 2023/8/1
 */
@Getter
public abstract class AbstractPictureResource implements Resource {

  // 图片公用成员变量和方法可以定义在这个类中

  private String url;

  public AbstractPictureResource() {}

  public AbstractPictureResource(String url) {
    this.url = url;
  }

  @Override
  public InputStream getInputStream() {
    return null;
  }
}


package xyz.xiaolinz.demo.factory.abstractFactory.product;

import java.io.InputStream;
import lombok.Getter;

/**
 * @author huangmuhong
 * @version 1.0.0
 * @date 2023/8/1
 */
@Getter
public abstract class AbstractVideoResource implements Resource {

  // 视频公用成员变量和方法可以定义在这个类中

  private String url;

  public AbstractVideoResource() {}

  public AbstractVideoResource(String url) {
    this.url = url;
  }

  @Override
  public InputStream getInputStream() {
    return null;
  }
}


package xyz.xiaolinz.demo.factory.abstractFactory.product;

/**
 * @author huangmuhong
 * @version 1.0.0
 * @date 2023/8/1
 */
public class ClasspathPictureResource extends AbstractPictureResource {

  public ClasspathPictureResource() {}

  public ClasspathPictureResource(String url) {
    super(url);
  }
}

package xyz.xiaolinz.demo.factory.abstractFactory.product;
/**
 * @author huangmuhong
 * @version 1.0.0
 * @date 2023/8/1
 */
public class ClasspathVideoResource extends AbstractVideoResource {

  public ClasspathVideoResource() {}

  public ClasspathVideoResource(String url) {
    super(url);
  }
}

package xyz.xiaolinz.demo.factory.abstractFactory.product;
/**
 * @author huangmuhong
 * @version 1.0.0
 * @date 2023/8/1
 */
public class HttpPictureResource extends AbstractPictureResource {

  public HttpPictureResource() {}

  public HttpPictureResource(String url) {
    super(url);
  }
}

package xyz.xiaolinz.demo.factory.abstractFactory.product;
/**
 * @author huangmuhong
 * @version 1.0.0
 * @date 2023/8/1
 */
public class HttpVideoResource extends AbstractVideoResource {

  public HttpVideoResource() {}

  public HttpVideoResource(String url) {
    super(url);
  }
}

```

定义抽象工厂接口，该接口可以生成一类对象族，如图片资源、视频资源等
```java
package xyz.xiaolinz.demo.factory.abstractFactory.factory;

import xyz.xiaolinz.demo.factory.abstractFactory.product.AbstractPictureResource;
import xyz.xiaolinz.demo.factory.abstractFactory.product.AbstractVideoResource;

/**
 * 抽象工厂模式
 *
 * <p>为创建一组相关或相互依赖的对象提供一个接口，而无需指定它们的具体类 每一个工厂实例都可以创建一个对象簇，这些对象可以是抽象的，也可以是具体的
 *
 * @author huangmuhong
 * @version 1.0.0
 * @date 2023/08/01
 */
public interface ResourceLoaderFactory {

  /**
   * 加载图片资源的抽象工厂方法
   *
   * @param url 地址
   * @return {@link AbstractPictureResource}
   */
  AbstractPictureResource loaderPicture(String url);

  /**
   * 加载视频资源的抽象工厂方法
   *
   * @param url 地址
   * @return {@link AbstractVideoResource}
   */
  AbstractVideoResource loaderVideo(String url);
}

```

这样子我们只需要实现具体的资源加载工厂就可以同时生产视频和图片的对象了
```java
package xyz.xiaolinz.demo.factory.abstractFactory.factory;

import xyz.xiaolinz.demo.factory.abstractFactory.product.AbstractPictureResource;
import xyz.xiaolinz.demo.factory.abstractFactory.product.AbstractVideoResource;
import xyz.xiaolinz.demo.factory.abstractFactory.product.ClasspathPictureResource;
import xyz.xiaolinz.demo.factory.abstractFactory.product.ClasspathVideoResource;

/**
 * @author huangmuhong
 * @version 1.0.0
 * @date 2023/8/1
 */
public class ClasspathResourceLoaderFactory extends AbstractResourceLoaderFactory {

  @Override
  public AbstractPictureResource loaderPicture(String url) {
    return new ClasspathPictureResource(url);
  }

  @Override
  public AbstractVideoResource loaderVideo(String url) {
    return new ClasspathVideoResource(url);
  }
}

```

