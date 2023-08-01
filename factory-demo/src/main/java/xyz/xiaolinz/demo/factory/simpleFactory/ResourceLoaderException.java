package xyz.xiaolinz.demo.factory.simpleFactory;

import java.io.Serial;

/**
 * @author huangmuhong
 * @version 1.0.0
 * @date 2023/7/27
 */
public class ResourceLoaderException extends RuntimeException {

  @Serial private static final long serialVersionUID = -6816983568181761093L;

  public ResourceLoaderException() {
    super("资源加载异常");
  }

  public ResourceLoaderException(String message) {
    super(message);
  }

  public ResourceLoaderException(String message, Throwable cause) {
    super(message, cause);
  }
}
