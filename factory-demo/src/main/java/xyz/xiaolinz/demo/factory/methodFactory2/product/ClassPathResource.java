package xyz.xiaolinz.demo.factory.methodFactory2.product;

import java.io.InputStream;

/**
 * @author huangmuhong
 * @version 1.0.0
 * @date 2023/8/1
 */
public class ClassPathResource extends AbstractResource {

  public ClassPathResource() {}

  public ClassPathResource(String url) {
    super(url);
  }

  @Override
  public InputStream getInputStream() {
    return null;
  }
}
