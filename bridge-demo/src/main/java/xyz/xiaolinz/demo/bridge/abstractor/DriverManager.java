package xyz.xiaolinz.demo.bridge.abstractor;

/**
 * @author huangmuhong
 * @date 2023/8/9
 */
public abstract class DriverManager {

  // 桥接模式 - 抽象化角色
  private Driver driver;

  public Connection getConnection() {
    return driver.connect();
  }

  public void registerDriver(Driver driver) {
    this.driver = driver;
  }
}
