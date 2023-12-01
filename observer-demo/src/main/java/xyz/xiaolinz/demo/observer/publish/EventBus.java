package xyz.xiaolinz.demo.observer.publish;

import java.lang.reflect.Type;
import java.util.ArrayList;
import org.springframework.util.LinkedMultiValueMap;

/**
 * 事件总线
 *
 * @author huangmuhong
 * @version 1.0.0
 * @date 2023/12/01
 */
public class EventBus implements EventBusInterface {

    private final LinkedMultiValueMap<Type, SubscriberListener<? extends SubscriberObject>> subscriberListenerMap =
        new LinkedMultiValueMap<>();

    @Override
    public EventBus register(SubscriberListener<? extends SubscriberObject> subscriber) {
        // 获取泛型的类型
        final var genericType = subscriber.getClass().getGenericInterfaces()[0];
        subscriberListenerMap.computeIfAbsent(genericType, k -> new ArrayList<>()).add(subscriber);
        return this;
    }

    @Override
    public void publish(SubscriberObject event) {
        final var subscriberListeners = subscriberListenerMap.get(event.getClass());
        if (subscriberListeners == null) {
            return;
        }
        subscriberListeners.forEach(subscriberListener -> subscriberListener.onEvent(event));
    }
}
