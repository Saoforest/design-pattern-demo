package xyz.xiaolinz.demo.factory.abstractFactory.product;

import java.io.InputStream;
import lombok.Getter;

/**
 * @author huangmuhong
 * @version 1.0.0
 * @date 2023/8/1
 */
@Getter
public abstract class AbstractVideoResource implements Resource {

  // 视频公用成员变量和方法可以定义在这个类中

  private String url;

  public AbstractVideoResource() {}

  public AbstractVideoResource(String url) {
    this.url = url;
  }

  @Override
  public InputStream getInputStream() {
    return null;
  }
}
