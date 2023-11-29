package xyz.xiaolinz.demo.facade;

/**
 * http端点服务
 *
 * @author huangmuhong
 * @date 2023/11/27
 * @version 1.0.0
 * @see EndpointService
 */
public class HttpEndpointService implements EndpointService {

  @Override
  public void doSomething() {
    System.out.println("HttpEndpointService do something");
  }
}
