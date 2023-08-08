package xyz.xiaolinz.demo.proxy.dynamicproxy.cglib;

import lombok.extern.slf4j.Slf4j;

/**
 * @author huangmuhong
 * @version 1.0.0
 * @date 2023/8/4
 */
@Slf4j
public class DataBaseDataQuery {

  public String query(String queryKey) {
    // 使用数据源查询数据
    log.info("从数据库查询数据");
    return "query";
  }

  public String queryAll() {
    log.info("从数据库查询所有数据");
    return "queryAll";
  }
}
