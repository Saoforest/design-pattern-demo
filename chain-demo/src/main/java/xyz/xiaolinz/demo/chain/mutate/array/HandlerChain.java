package xyz.xiaolinz.demo.chain.mutate.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 处理链
 *
 * @author huangmuhong
 * @version 1.0.0
 * @date 2024/02/20
 */
public class HandlerChain {

    private final List<Handler> handlers = new ArrayList<>();

    public void addHandler(Handler... handlers) {
        this.handlers.addAll(Arrays.asList(handlers));
    }

    public void handle() {
        for (Handler handler : handlers) {
            handler.handle();
        }
    }
}
