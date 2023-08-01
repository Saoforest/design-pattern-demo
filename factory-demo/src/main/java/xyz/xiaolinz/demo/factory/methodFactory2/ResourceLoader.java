package xyz.xiaolinz.demo.factory.methodFactory2;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import xyz.xiaolinz.demo.factory.methodFactory2.factory.ResourceLoaderFactory;
import xyz.xiaolinz.demo.factory.methodFactory2.product.AbstractResource;
import xyz.xiaolinz.demo.factory.simpleFactory.Resource;
import xyz.xiaolinz.demo.factory.simpleFactory.ResourceLoaderException;

/**
 * @author huangmuhong
 * @version 1.0.0
 * @date 2023/8/1
 */
public class ResourceLoader {

  //  private ResourceLoaderFactory factory;

  private final Map<String, ResourceLoaderFactory> factoryMap = new HashMap<>(10);

  // TODO 符合开闭原则，通过配置文件的方式，可以动态的添加新的资源加载器
  {
    final var inputStream =
        Thread.currentThread()
            .getContextClassLoader()
            .getResourceAsStream("resouceLoader2.properties");
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
  public AbstractResource load(String url) {

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
