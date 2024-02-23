package xyz.xiaolinz.demo.chain.tradition.linked;

/**
 * @author huangmuhong
 * @date 2024/2/20
 */
public abstract class AbstractHandler implements Handler {

    private Handler next;

    @Override
    public Handler getNext() {
        return next;
    }

    @Override
    public void setNext(Handler handler) {
        this.next = handler;
    }
}
