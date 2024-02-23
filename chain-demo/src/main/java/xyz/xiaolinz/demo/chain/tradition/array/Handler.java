package xyz.xiaolinz.demo.chain.tradition.array;

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

}
