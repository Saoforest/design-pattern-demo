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
