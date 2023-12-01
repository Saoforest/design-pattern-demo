package xyz.xiaolinz.demo.observer.calculator;

/**
 * 主题
 *
 * @author huangmuhong
 * @version 1.0.0
 * @date 2023/12/01
 */
public interface Subject {

    /**
     * 注册观察员
     *
     * @param o 哦
     * @author huangmuhong
     * @date 2023/12/01
     * @since 1.0.0
     */
    void registerObserver(Observer o);

    /**
     * 删除观察者
     *
     * @param o 哦
     * @author huangmuhong
     * @date 2023/12/01
     * @since 1.0.0
     */
    void removeObserver(Observer o);

    /**
     * 通知观察员
     *
     * @author huangmuhong
     * @date 2023/12/01
     * @since 1.0.0
     */
    void notifyObservers();

}
