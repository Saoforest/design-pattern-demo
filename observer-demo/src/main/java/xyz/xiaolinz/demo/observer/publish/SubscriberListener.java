package xyz.xiaolinz.demo.observer.publish;

/**
 * 订阅者监听器
 *
 * @author huangmuhong
 * @version 1.0.0
 * @date 2023/12/01
 */
@FunctionalInterface
public interface SubscriberListener<Event extends SubscriberObject> {

    /**
     * 执行事件
     *
     * @param event 事件
     * @author huangmuhong
     * @date 2023/12/01
     * @since 1.0.0
     */
    void onEvent(Event event);

}
