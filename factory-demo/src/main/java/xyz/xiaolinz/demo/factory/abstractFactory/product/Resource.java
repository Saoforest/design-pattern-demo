package xyz.xiaolinz.demo.factory.abstractFactory.product;

import java.io.InputStream;

/**
 * @author huangmuhong
 * @version 1.0.0
 * @date 2023/8/1
 */
public interface Resource {

  /**
   * 获取输入流
   *
   * @return {@link InputStream}
   */
  InputStream getInputStream();
}
