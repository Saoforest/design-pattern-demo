package xyz.xiaolinz.demo.factory.abstractFactory.product;
/**
 * @author huangmuhong
 * @version 1.0.0
 * @date 2023/8/1
 */
public class HttpPictureResource extends AbstractPictureResource {

  public HttpPictureResource() {}

  public HttpPictureResource(String url) {
    super(url);
  }
}
