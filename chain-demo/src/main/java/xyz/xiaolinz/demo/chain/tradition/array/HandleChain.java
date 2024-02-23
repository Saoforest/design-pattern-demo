package xyz.xiaolinz.demo.chain.tradition.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 手柄链
 *
 * @author huangmuhong
 * @version 1.0.0
 * @date 2024/02/20
 */
public class HandleChain {

    private final List<Handler> handlers = new ArrayList<>();

    public void addHandler(Handler... handlers) {
        Collections.addAll(this.handlers, handlers);
    }

    /**
     * 处理
     *
     * @return void
     * @date 2024/02/20
     * @since 1.0.0
     */
    public void handle() {
        for (Handler handler : handlers) {
            if (handler.handle()) {
                break;
            }
        }
    }
}
