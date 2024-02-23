package xyz.xiaolinz.demo.chain.mutate.recurve;

/**
 * 处理器
 *
 * @author huangmuhong
 * @version 1.0.0
 * @date 2024/02/23
 */
public interface Handler {

    /**
     * 处理
     *
     * @param context      上下文
     * @param handlerChain 处理链
     * @author huangmuhong
     * @date 2024/02/23
     * @since 1.0.0
     */
    void handle(Context context, HandlerChain handlerChain);

    /**
     * 排序
     *
     * @return int
     * @author huangmuhong
     * @date 2024/02/23
     * @since 1.0.0
     */
    int order();

}
