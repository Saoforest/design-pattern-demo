package xyz.xiaolinz.demo.bridge;

import lombok.SneakyThrows;
import xyz.xiaolinz.demo.bridge.abstractor.Driver;
import xyz.xiaolinz.demo.bridge.abstractor.DriverManagerOne;

/**
 * @author huangmuhong
 * @date 2023/8/9
 */
public class Main {
  @SneakyThrows
  public static void main(String[] args) {
    // 先创建一个驱动实例
    final var mysqlDriver =
        ((Driver)
            Class.forName("xyz.xiaolinz.demo.bridge.impl.OracleDriver")
                .getDeclaredConstructor()
                .newInstance());

    // 注册驱动
    final var driverManagerOne = new DriverManagerOne();
    driverManagerOne.registerDriver(mysqlDriver);

    // 获取连接
    final var connection = driverManagerOne.getConnection();
    System.out.println(connection);
  }
}
