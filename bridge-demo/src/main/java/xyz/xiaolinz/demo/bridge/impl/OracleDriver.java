package xyz.xiaolinz.demo.bridge.impl;

import xyz.xiaolinz.demo.bridge.abstractor.Connection;
import xyz.xiaolinz.demo.bridge.abstractor.Driver;

/**
 * 桥接设计模式 - 抽象角色
 *
 * @author huangmuhong
 * @date 2023/08/11
 * @version 1.0.0
 * @see Driver
 */
public class OracleDriver implements Driver {

  @Override
  public Connection connect() {
    return new Connection("oracle");
  }
}
