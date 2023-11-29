package xyz.xiaolinz.demo.bridge.impl;

import xyz.xiaolinz.demo.bridge.abstractor.Connection;
import xyz.xiaolinz.demo.bridge.abstractor.Driver;

/**
 * 桥接模式 - 抽象化角色的具体实现 oracle 驱动
 *
 * @author huangmuhong
 * @date 2023/11/27
 * @version 1.0.0
 * @see Driver
 */
public class OracleDriver implements Driver {

  @Override
  public Connection connect() {
    return new Connection("oracle");
  }
}
