package xyz.xiaolinz.demo.facade;

/**
 * 门面模式 - 门面角色
 * 提供对外的统一接口
 * 通过组合的方式，将多个服务组合在一起
 *
 * @author huangmuhong
 * @date 2023/11/27
 * @version 1.0.0
 *
 */
public class EndpointFacade {

  private final EndpointService discoveryEndpointService;

  private final EndpointService httpEndpointService;

  public EndpointFacade(EndpointService discoveryEndpointService,
      EndpointService httpEndpointService) {
    this.discoveryEndpointService = discoveryEndpointService;
    this.httpEndpointService = httpEndpointService;
  }

  public void doSomething() {
    discoveryEndpointService.doSomething();
    httpEndpointService.doSomething();
  }

}
