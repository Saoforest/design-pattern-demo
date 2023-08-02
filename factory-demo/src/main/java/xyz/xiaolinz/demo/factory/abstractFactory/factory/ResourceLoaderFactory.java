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
