package xyz.xiaolinz.demo.observer.publish;

/**
 * 应用程序订阅者侦听器
 *
 * @author huangmuhong
 * @version 1.0.0
 * @date 2023/12/02
 * @see SubscriberListener
 */
public class AppSubscriberListener implements SubscriberListener<AppSubscriberObject> {
    @Override
    public void onEvent(AppSubscriberObject appSubscriberObject) {
        System.out.println("我的名字是：" + appSubscriberObject.getName() + "，我收到了消息");
    }
}
