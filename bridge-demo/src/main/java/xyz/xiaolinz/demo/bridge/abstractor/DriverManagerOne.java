package xyz.xiaolinz.demo.bridge.abstractor;
/**
 * @author huangmuhong
 * @date 2023/8/9
 */
public class DriverManagerOne extends DriverManager {

  @Override
  public Connection getConnection() {
    System.out.println("这是由DriverManagerOne实现的getConnection方法");
    return super.getConnection();
  }
}
