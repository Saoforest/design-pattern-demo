package xyz.xiaolinz.demo.chain.tradition.linked;

/**
 * 责任链设计模式 - 链表实现
 *
 * 具体处理器
 *
 * @author huangmuhong
 * @version 1.0.0
 * @date 2024/02/20
 * @see Handler
 */
public class AHandler extends AbstractHandler {
    @Override
    public boolean handle() {
        System.out.println("AHandler handle");
        boolean handled = false;
        //...
        if (!handled && getNext() != null) {
            return getNext().handle();
        }
        return handled;
    }
}
