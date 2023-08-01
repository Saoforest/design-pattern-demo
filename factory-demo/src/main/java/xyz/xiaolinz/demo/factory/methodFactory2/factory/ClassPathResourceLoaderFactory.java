package xyz.xiaolinz.demo.factory.methodFactory2.factory;

import xyz.xiaolinz.demo.factory.methodFactory2.product.AbstractResource;
import xyz.xiaolinz.demo.factory.methodFactory2.product.ClassPathResource;

/**
 * http资源加载器
 *
 * @author huangmuhong
 * @version 1.0.0
 * @date 2023/08/01
 */
public class ClassPathResourceLoaderFactory implements ResourceLoaderFactory {

  @Override
  public AbstractResource loader(String url) {
    // 省略复杂的业务创建过程
    return new ClassPathResource(url);
  }
}
