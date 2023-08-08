package xyz.xiaolinz.demo.proxy.dynamicproxy.cglib;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

/**
 * 缓存方法拦截器
 *
 * <p>实现了 Spring 的 MethodInterceptor 接口，这个接口是 CGLIB 的方法拦截器，用于拦截被代理对象的方法。 该接口只需要实现 intercept
 * 方法，该方法会在被代理对象的方法被调用时调用。 intercept 方法的参数说明：
 *
 * <ul>
 *   <li>obj：被代理对象
 *   <li>method：被代理对象的方法
 *   <li>args：被代理对象的方法的参数
 *   <li>proxy：代理人
 *   <li>返回值：被代理对象的方法的返回值
 *   <li>throws Throwable：可投掷
 * </ul>
 *
 * @author huangmuhong
 * @date 2023/08/08
 * @see MethodInterceptor
 */
@Slf4j
public class CacheMethodInterceptor implements MethodInterceptor {

  private final Map<String, String> cache = new HashMap<>(10);

  /**
   * 截距
   *
   * @param obj 对象
   * @param method 方法
   * @param args 参数
   * @param proxy 代理人
   * @return {@link Object }
   * @author huangmuhong
   * @date 2023/08/08
   */
  @Override
  public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy)
      throws Throwable {
    // 我们只对 query 方法进行缓存
    if (method.getName().equals("query")) {
      if (cache.containsKey(args[0])) {
        log.info("从缓存中查询数据");
        return cache.get(args[0]);
      }
      // 从数据库查询数据
      final var result = proxy.invokeSuper(obj, args);
      // 将查询结果缓存
      cache.put((String) args[0], (String) result);
      return result;
    }

    // 调用默认的方法
    return proxy.invokeSuper(obj, args);
  }
}
