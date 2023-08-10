package xyz.xiaolinz.demo.bridge.abstractor;

/**
 * 驱动经理二
 *
 * @author huangmuhong
 * @date 2023/08/10
 * @version 1.0.0
 * @see DriverManager
 */
public class DriverManagerTwo extends DriverManager {

  /**
   *
   * 获得连接
   *
   * @return {@link Connection }
   * @author huangmuhong
   * @date 2023/08/10
   * @since 1.0.0
   */
  @Override
  public Connection getConnection() {
    System.out.println("这是由DriverManagerTwo实现的getConnection方法");
    return super.getConnection();
  }
}
