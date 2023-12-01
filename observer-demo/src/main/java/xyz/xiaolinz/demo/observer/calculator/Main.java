package xyz.xiaolinz.demo.observer.calculator;

/**
 * 主要
 *
 * @author huangmuhong
 * @version 1.0.0
 * @date 2023/12/01
 */
public class Main {
    public static void main(String[] args) {
        final WeatherStation weatherStation = new WeatherStation();
        final PhoneApp phoneApp = new PhoneApp();
        weatherStation.registerObserver(phoneApp);
        weatherStation.setMeasurements(1, 2, 3);
    }
}
