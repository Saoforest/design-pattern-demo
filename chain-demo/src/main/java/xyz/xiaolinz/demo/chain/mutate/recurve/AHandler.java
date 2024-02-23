package xyz.xiaolinz.demo.chain.mutate.recurve;

/**
 * @author huangmuhong
 * @date 2024/2/23
 */
public class AHandler implements Handler {
    @Override
    public void handle(Context context, HandlerChain handlerChain) {
        System.out.println("这里是AHandler,我将是第一个处理器，上下文中的数据是：" + context.getDesc());
        handlerChain.handle(context);
    }

    @Override
    public int order() {
        return 1;
    }
}
