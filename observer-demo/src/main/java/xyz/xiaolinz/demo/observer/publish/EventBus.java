package xyz.xiaolinz.demo.observer.publish;

import java.lang.reflect.ParameterizedType;
import org.springframework.util.LinkedMultiValueMap;

/**
 * 事件总线
 *
 * @author huangmuhong
 * @version 1.0.0
 * @date 2023/12/01
 */
public class EventBus implements EventBusInterface {

    private final LinkedMultiValueMap<Class<SubscriberObject>, SubscriberListener<?>> subscriberListenerMap =
        new LinkedMultiValueMap<>();

    @Override
    public EventBusInterface register(SubscriberListener<?> subscriber) {
        // 寻找泛型为 SubscriberObject 的class
        final var genericInterfaces = subscriber.getClass().getGenericInterfaces();
        for (var genericInterface : genericInterfaces) {
            if (genericInterface instanceof Class) {
                continue;
            }
            final var parameterizedType = (ParameterizedType)genericInterface;
            final var actualTypeArguments = parameterizedType.getActualTypeArguments();
            for (var actualTypeArgument : actualTypeArguments) {
                if (actualTypeArgument instanceof Class) {
                    final var subscriberObjectClass = (Class<SubscriberObject>)actualTypeArgument;
                    subscriberListenerMap.add(subscriberObjectClass, subscriber);
                }
            }
        }
        return this;
    }

    @Override
    public void publish(SubscriberObject event) {
        final var subscriberListeners = subscriberListenerMap.get(event.getClass());
        if (subscriberListeners == null) {
            return;
        }
        for (var subscriberListener : subscriberListeners) {
            final var subscriber = (SubscriberListener<SubscriberObject>)subscriberListener;
            subscriber.onEvent(event);
        }
    }
}
