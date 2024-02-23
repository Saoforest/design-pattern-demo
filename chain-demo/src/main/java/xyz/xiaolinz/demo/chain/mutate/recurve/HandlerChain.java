package xyz.xiaolinz.demo.chain.mutate.recurve;

/**
 * 处理链
 *
 * @author huangmuhong
 * @version 1.0.0
 * @date 2024/02/23
 */
public interface HandlerChain {

    /**
     * 处理
     *
     * @param context 上下文
     * @author huangmuhong
     * @date 2024/02/23
     * @since 1.0.0
     */
    void handle(Context context);

}
