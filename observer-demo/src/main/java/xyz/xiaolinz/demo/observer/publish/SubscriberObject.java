package xyz.xiaolinz.demo.observer.publish;

import lombok.Data;

/**
 * 订户对象
 *
 * @author huangmuhong
 * @version 1.0.0
 * @date 2023/12/01
 */
@Data
public abstract class SubscriberObject {

    private final Object source;

    private final long timestamp;

    public SubscriberObject(Object source) {
        if (source == null) {
            throw new IllegalArgumentException("source must not be null");
        }
        this.source = source;
        this.timestamp = System.currentTimeMillis();
    }

}
