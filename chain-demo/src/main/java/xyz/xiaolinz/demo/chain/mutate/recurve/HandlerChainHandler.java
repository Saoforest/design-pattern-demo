package xyz.xiaolinz.demo.chain.mutate.recurve;

import java.util.Comparator;
import java.util.List;

/**
 * 处理程序链处理程序
 *
 * @author huangmuhong
 * @version 1.0.0
 * @date 2024/02/23
 */
public class HandlerChainHandler {

    private List<Handler> handlers;

    public HandlerChainHandler(List<Handler> handlers) {
        this.handlers = handlers;
    }

    /**
     * 处理
     *
     * @author huangmuhong
     * @date 2024/02/23
     * @since 1.0.0
     */
    public void handle(Context context) {
        // 排序过滤器链
        handlers.sort(Comparator.comparingInt(Handler::order));

        // 递归调用
        new DefaultHandlerChain(handlers).handle(context);
    }

    /**
     * 默认处理程序链
     *
     * @author huangmuhong
     * @version 1.0.0
     * @date 2024/02/23
     * @see HandlerChain
     */
    static class DefaultHandlerChain implements HandlerChain {
        private final List<Handler> handlers;

        private int pos;

        public DefaultHandlerChain(List<Handler> handlers) {
            this.handlers = handlers;
        }

        @Override
        public void handle(Context context) {
            if (pos < handlers.size()) {
                Handler handler = handlers.get(pos++);
                handler.handle(context, this);
            }
        }
    }
}
