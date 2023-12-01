package xyz.xiaolinz.demo.observer.calculator;

import java.util.ArrayList;
import java.util.List;

/**
 * 气象站
 *
 * @author huangmuhong
 * @version 1.0.0
 * @date 2023/12/01
 */
public class WeatherStation implements Subject {

    private final List<Observer> observers = new ArrayList<>();

    // 温度
    private float temperature;
    // 湿度
    private float humidity;
    // 大气压
    private float pressure;

    @Override
    public void registerObserver(Observer o) {
        if (!observers.contains(o)) {
            observers.add(o);
        }
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        observers.forEach(observer -> observer.update(temperature, humidity, pressure));
    }

    /**
     * 设置测量值
     *
     * @param temperature 温度
     * @param humidity    湿度
     * @param pressure    压力
     * @author huangmuhong
     * @date 2023/12/01
     * @since 1.0.0
     */
    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        // 测量值发生了变化
        notifyObservers();
    }

}
