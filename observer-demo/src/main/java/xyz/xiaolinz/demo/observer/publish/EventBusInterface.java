package xyz.xiaolinz.demo.observer.publish;

/**
 * 事件总线接口
 *
 * @author huangmuhong
 * @version 1.0.0
 * @date 2023/12/01
 */
public interface EventBusInterface {

    /**
     * 登记
     *
     * @param subscriber 订户
     * @return {@link EventBusInterface }
     * @author huangmuhong
     * @date 2023/12/02
     * @since 1.0.0
     */
    EventBusInterface register(SubscriberListener<?> subscriber);

    /**
     * 发布
     *
     * @param event 事件
     * @author huangmuhong
     * @date 2023/12/01
     * @since 1.0.0
     */
    void publish(SubscriberObject event);

}
