package xyz.xiaolinz.demo.observer.publish;

import lombok.Getter;

/**
 * 应用程序订阅者对象
 *
 * @author huangmuhong
 * @version 1.0.0
 * @date 2023/12/02
 * @see SubscriberObject
 */
@Getter
public class AppSubscriberObject extends SubscriberObject {

    private final String name;

    public AppSubscriberObject(Object source) {
        super(source);
        this.name = "AppSubscriberObject";
    }
}
