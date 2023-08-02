package xyz.xiaolinz.demo.factory.abstractFactory.factory;

import xyz.xiaolinz.demo.factory.abstractFactory.product.AbstractPictureResource;
import xyz.xiaolinz.demo.factory.abstractFactory.product.AbstractVideoResource;
import xyz.xiaolinz.demo.factory.abstractFactory.product.ClasspathPictureResource;
import xyz.xiaolinz.demo.factory.abstractFactory.product.ClasspathVideoResource;

/**
 * @author huangmuhong
 * @version 1.0.0
 * @date 2023/8/1
 */
public class ClasspathResourceLoaderFactory extends AbstractResourceLoaderFactory {

  @Override
  public AbstractPictureResource loaderPicture(String url) {
    return new ClasspathPictureResource(url);
  }

  @Override
  public AbstractVideoResource loaderVideo(String url) {
    return new ClasspathVideoResource(url);
  }
}
