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
