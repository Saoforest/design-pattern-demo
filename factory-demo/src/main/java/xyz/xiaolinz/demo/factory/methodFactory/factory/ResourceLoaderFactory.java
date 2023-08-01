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
