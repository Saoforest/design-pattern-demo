package xyz.xiaolinz.demo.observer.calculator;

/**
 * 电话应用程序
 *
 * @author huangmuhong
 * @version 1.0.0
 * @date 2023/12/01
 * @see Observer
 */
public class PhoneApp implements Observer {
    @Override
    public void update(float temperature, float humidity, float pressure) {
        System.out.println("手机端收到了气象站的数据，温度：" + temperature + "，湿度：" + humidity + "，压力：" + pressure);
    }
}
