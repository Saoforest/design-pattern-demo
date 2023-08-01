package xyz.xiaolinz.demo.factory.methodFactory2.product;

import java.io.InputStream;

/**
 * @author huangmuhong
 * @version 1.0.0
 * @date 2023/8/1
 */
public class HttpResource extends AbstractResource {

  public HttpResource() {}

  public HttpResource(String url) {
    super(url);
  }

  @Override
  public InputStream getInputStream() {
    return null;
  }
}
