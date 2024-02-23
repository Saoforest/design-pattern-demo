package xyz.xiaolinz.demo.chain.tradition.linked;

/**
 * 责任链设计模式 - 链表方式实现
 *
 * 处理器接口
 *
 * @author huangmuhong
 * @version 1.0.0
 * @date 2024/02/20
 */
public interface Handler {

    /**
     * 处理
     *
     * @return boolean
     * @author huangmuhong
     * @date 2024/02/20
     * @since 1.0.0
     */
    boolean handle();

    /**
     * 获取下一个处理器
     *
     * @return {@link Handler }
     * @date 2024/02/20
     * @since 1.0.0
     */
    Handler getNext();

    /**
     * 设置下一个处理器
     *
     * @param handler 下一个处理器
     * @return void
     * @date 2024/02/20
     * @since 1.0.0
     */
    void setNext(Handler handler);

}
