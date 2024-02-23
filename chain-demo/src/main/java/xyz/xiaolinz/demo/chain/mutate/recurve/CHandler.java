package xyz.xiaolinz.demo.chain.mutate.recurve;

/**
 * @author huangmuhong
 * @date 2024/2/23
 */
public class CHandler implements Handler {
    @Override
    public void handle(Context context, HandlerChain handlerChain) {
        System.out.println("这里是CHandler，我将是第二个处理器，上下文中的数据是：" + context.getDesc());
        handlerChain.handle(context);
    }

    @Override
    public int order() {
        return 2;
    }
}
