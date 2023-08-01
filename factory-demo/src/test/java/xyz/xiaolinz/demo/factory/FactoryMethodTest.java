package xyz.xiaolinz.demo.factory;

import org.junit.Test;
import xyz.xiaolinz.demo.factory.methodFactory2.ResourceLoader;

/**
 * @author huangmuhong
 * @version 1.0.0
 * @date 2023/8/1
 */
public class FactoryMethodTest {

  @Test
  public void factoryMethodTest() {
    var url = "classpath://application.yml";
    final var resourceLoader = new ResourceLoader();
    final var load = resourceLoader.load(url);
    System.out.println(load.getUrl());
  }
}
