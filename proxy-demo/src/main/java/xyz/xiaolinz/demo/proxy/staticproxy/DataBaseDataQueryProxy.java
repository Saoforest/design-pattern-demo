package xyz.xiaolinz.demo.proxy.staticproxy;

import java.util.HashMap;
import java.util.Map;

/**
 * 数据库数据查询代理 1. 屏蔽被代理对象的具体实现 2. 增强被代理对象的功能 3. 代理对象和被代理对象实现同一个接口，方便扩展
 *
 * @author huangmuhong
 * @version 1.0.0
 * @date 2023/8/4
 */
public class DataBaseDataQueryProxy implements DataQuery {

  // 实现缓存
  private final Map<String, String> cache = new HashMap<>();

  // 持有被代理对象
  private final DataQuery dataQuery;

  public DataBaseDataQueryProxy() {
    this.dataQuery = new DataBaseDataQuery();
  }

  @Override
  public String query(String queryKey) {
    // 增强被代理对象的功能, 实现缓存功能
    return cache.computeIfAbsent(queryKey, dataQuery::query);
  }
}
