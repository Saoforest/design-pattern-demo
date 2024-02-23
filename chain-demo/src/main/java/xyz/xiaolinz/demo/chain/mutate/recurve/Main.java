package xyz.xiaolinz.demo.chain.mutate.recurve;

import java.util.ArrayList;

/**
 * @author huangmuhong
 * @date 2024/2/23
 */
public class Main {
    public static void main(String[] args) {
        Context context = new Context();
        context.setDesc("This is a context.");
        final ArrayList<Handler> handlers = new ArrayList<>();
        handlers.add(new AHandler());
        handlers.add(new BHandler());
        handlers.add(new CHandler());

        final HandlerChainHandler handlerChainHandler = new HandlerChainHandler(handlers);
        handlerChainHandler.handle(context);

    }
}
