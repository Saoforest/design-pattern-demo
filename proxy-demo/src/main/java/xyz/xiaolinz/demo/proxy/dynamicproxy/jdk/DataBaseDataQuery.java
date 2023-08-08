package xyz.xiaolinz.demo.proxy.dynamicproxy.jdk;

/**
 * @author huangmuhong
 * @version 1.0.0
 * @date 2023/8/4
 */
public class DataBaseDataQuery implements DataQuery {

  @Override
  public String query(String queryKey) {
    // 使用数据源查询数据
    System.out.println("从数据库查询数据");
    return "query";
  }

  @Override
  public String queryAll() {
    return "queryAll";
  }
}
