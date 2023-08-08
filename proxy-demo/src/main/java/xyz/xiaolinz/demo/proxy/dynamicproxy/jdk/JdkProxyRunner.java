package xyz.xiaolinz.demo.proxy.dynamicproxy.jdk;

import java.lang.reflect.Proxy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * @author huangmuhong
 * @version 1.0.0
 * @date 2023/8/7
 */
@Component
@Slf4j
public class JdkProxyRunner implements ApplicationRunner {

  @Override
  public void run(ApplicationArguments args) throws Exception {
    // jdk动态代理主要通过 Proxy 类来完成
    /**
     * 1. classLoader: 类加载器，用于加载代理类，可以通过被代理类的class.getClassLoader()获取 2. interfaces:
     * 被代理类的接口，可以通过被代理类的class.getInterfaces()获取 3. invocationHandler: 代理类的调用处理器，需要实现
     * InvocationHandler 接口
     */
    final var classLoader = Thread.currentThread().getContextClassLoader();
    Class[] interfaces = new Class[] {DataQuery.class};
    final var cacheInvocationHandler = new CacheInvocationHandler(new DataBaseDataQuery());
    final var proxy =
        ((DataQuery) Proxy.newProxyInstance(classLoader, interfaces, cacheInvocationHandler));

    log.info(proxy.query("test"));

    log.info(proxy.query("test"));
  }
}
