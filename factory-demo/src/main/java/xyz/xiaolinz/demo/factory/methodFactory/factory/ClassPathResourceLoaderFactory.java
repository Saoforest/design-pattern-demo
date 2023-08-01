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
