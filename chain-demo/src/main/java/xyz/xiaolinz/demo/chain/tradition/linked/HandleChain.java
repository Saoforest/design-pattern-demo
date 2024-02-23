package xyz.xiaolinz.demo.chain.tradition.linked;

/**
 * 处理器链
 *
 * @author huangmuhong
 * @version 1.0.0
 * @date 2024/02/20
 */
public class HandleChain {

    private Handler head;

    private Handler tail;

    /**
     * 添加处理程序
     *
     * @param handler 处理程序
     * @author huangmuhong
     * @date 2024/02/20
     * @since 1.0.0
     */
    public void addHandler(Handler handler) {
        handler.setNext(null);
        if (head == null) {
            head = handler;
            tail = handler;
            return;
        }
        tail.setNext(handler);
        tail = handler;
    }

    /**
     * 处理
     *
     * @author huangmuhong
     * @date 2024/02/20
     * @since 1.0.0
     */
    public void handle() {
        if (head != null) {
            head.handle();
        }
    }

}
