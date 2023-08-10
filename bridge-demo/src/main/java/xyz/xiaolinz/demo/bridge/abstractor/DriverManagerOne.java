package xyz.xiaolinz.demo.bridge.abstractor;
/**
 * 司机经理一号
 *
 * @author huangmuhong
 * @date 2023/08/10
 * @see DriverManager
 */
public class DriverManagerOne extends DriverManager {

  @Override
  public Connection getConnection() {
    System.out.println("这是由DriverManagerOne实现的getConnection方法");
    return super.getConnection();
  }
}
