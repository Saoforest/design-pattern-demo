package xyz.xiaolinz.demo.factory.methodFactory;

import java.util.HashMap;
import java.util.Map;
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
public class ResourceLoaderVersion2 {

  //  private ResourceLoaderFactory factory;

  private final Map<String, ResourceLoaderFactory> factoryMap = new HashMap<>(10);

  // TODO 符合开闭原则，通过提前缓存工厂实例从而去除了 if-else 分支判断
  {
    factoryMap.put("classpath", new ClassPathResourceLoaderFactory());
    factoryMap.put("http", new HttpResourceLoaderFactory());
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
