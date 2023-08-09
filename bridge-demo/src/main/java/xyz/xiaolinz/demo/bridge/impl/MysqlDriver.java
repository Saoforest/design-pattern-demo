package xyz.xiaolinz.demo.bridge.impl;

import xyz.xiaolinz.demo.bridge.abstractor.Connection;
import xyz.xiaolinz.demo.bridge.abstractor.Driver;

/**
 * @author huangmuhong
 * @date 2023/8/9
 */
public class MysqlDriver implements Driver {

  @Override
  public Connection connect() {
    return new Connection("mysql");
  }
}
