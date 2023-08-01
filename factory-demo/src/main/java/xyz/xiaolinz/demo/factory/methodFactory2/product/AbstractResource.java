package xyz.xiaolinz.demo.factory.methodFactory2.product;

import java.io.InputStream;
import lombok.Getter;

/**
 * 产品
 *
 * @author huangmuhong
 * @version 1.0.0
 * @date 2023/08/01
 */
@Getter
public abstract class AbstractResource {

  private String url;

  public AbstractResource() {}

  public AbstractResource(String url) {
    this.url = url;
  }

  protected void shared() {
    System.out.println("公共方法");
  }

  /**
   * 获取输入流
   *
   * @return {@link InputStream}
   */
  public abstract InputStream getInputStream();
}
