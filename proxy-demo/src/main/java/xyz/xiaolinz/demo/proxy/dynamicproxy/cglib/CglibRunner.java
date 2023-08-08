package xyz.xiaolinz.demo.proxy.dynamicproxy.cglib;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.stereotype.Component;

/**
 * @author huangmuhong
 * @date 2023/8/8
 */
@Component
public class CglibRunner implements ApplicationRunner {

  @Override
  public void run(ApplicationArguments args) throws Exception {
    // 创建被代理对象
    final var enhancer = new Enhancer();
    // cglib 跟 JDK 动态代理的不同之处在于，它是针对类实现代理的，原理是对指定的目标类生成一个子类，可以没有接口。
    // 我么这里的目标类是 DataBaseDataQuery，所以需要设置父类，且没有接口 CGLIB 也可以为我们创建动态代理的对象
    enhancer.setSuperclass(DataBaseDataQuery.class);
    // 设置方法拦截器
    enhancer.setCallback(new CacheMethodInterceptor());

    // 创建代理对象
    final var proxy = (DataBaseDataQuery) enhancer.create();

    // 调用代理对象的方法
    proxy.query("queryKey");
    proxy.query("queryKey");
    proxy.queryAll();
  }
}
