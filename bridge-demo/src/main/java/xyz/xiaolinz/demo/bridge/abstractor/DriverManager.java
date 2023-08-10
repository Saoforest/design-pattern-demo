package xyz.xiaolinz.demo.bridge.abstractor;

/**
 * 司机经理
 *
 * @author huangmuhong
 * @date 2023/08/10
 */
public abstract class DriverManager {

  // 桥接模式 - 抽象化角色
  private Driver driver;

  /**
   * 获得连接
   *
   *
   * @return {@link Connection }
   * @author huangmuhong
   * @date 2023/08/10
   */
  public Connection getConnection() {
    return driver.connect();
  }

  /**
   * 注册驱动程序
   *
   * @param driver 司机
   *
   * @author huangmuhong
   * @date 2023/08/10
   */
  public void registerDriver(Driver driver) {
    this.driver = driver;
  }
}
