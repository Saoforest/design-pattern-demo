package xyz.xiaolinz.demo.proxy.dynamicproxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @author huangmuhong
 * @version 1.0.0
 * @date 2023/8/7
 */
public class CacheInvocationHandler implements InvocationHandler {

  private final Map<String, String> cache = new HashMap<>(10);

  private final DataQuery bean;

  public CacheInvocationHandler(DataQuery bean) {
    this.bean = bean;
  }

  /**
   * @param proxy 代理对象
   * @param method 方法
   * @param args 参数
   * @return {@link Object}
   * @throws Throwable 可投掷
   */
  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    // 通过代理对象调用方法时，会调用这个方法

    // 判断是否是 query 方法
    if ("query".equals(method.getName())) {
      // 如果是 query 方法，就使用缓存
      if (cache.containsKey(args[0])) {
        System.out.println("从缓存中查询数据");
        return cache.get(args[0]);
      } else {
        // 如果没有缓存，就调用被代理对象的方法
        final var result = method.invoke(bean, args);
        // 将结果缓存
        cache.put((String) args[0], (String) result);
        return result;
      }
    }

    // 返回被代理对象的方法
    return method.invoke(bean, args);
  }
}
