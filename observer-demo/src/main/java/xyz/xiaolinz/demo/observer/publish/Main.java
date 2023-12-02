package xyz.xiaolinz.demo.observer.publish;

/**
 * @author huangmuhong
 * @date 2023/12/2
 */
public class Main {
    public static void main(String[] args) {
        EventBusInterface eventBus = new EventBus();
        eventBus.register(new AppSubscriberListener());
        eventBus.publish(new AppSubscriberObject(new Object()));
    }
}
