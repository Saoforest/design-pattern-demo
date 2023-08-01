package xyz.xiaolinz.demo.factory.methodFactory2.factory;

import xyz.xiaolinz.demo.factory.methodFactory2.product.AbstractResource;
import xyz.xiaolinz.demo.factory.simpleFactory.Resource;

/**
 * 工厂方法, 提供一个创建对象实例的功能，而无需关心其具体实现
 *
 * <p>通过提供一个工厂接口，让子类决定实例化哪一个类 <br>
 * 优点：
 *
 * <ul>
 *   <li>用户只需要关心所需产品对应的工厂，无需关心创建细节
 *   <li>加入新产品符合开闭原则，提高了系统的可扩展性
 *   <li>缺点：类的个数容易过多，增加了代码结构的复杂度
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
  AbstractResource loader(String url);
}
