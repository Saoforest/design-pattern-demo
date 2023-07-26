package xyz.xiaolinz.demo.factory.simple;
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
