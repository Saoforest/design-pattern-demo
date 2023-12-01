package xyz.xiaolinz.demo.observer.calculator;

/**
 * 观察者
 *
 * @author huangmuhong
 * @version 1.0.0
 * @date 2023/12/01
 */
public interface Observer {

    /**
     * 更新
     *
     * @param temperature 温度
     * @param humidity    湿度
     * @param pressure    压力
     * @author huangmuhong
     * @date 2023/12/01
     * @since 1.0.0
     */
    void update(float temperature, float humidity, float pressure);

}
