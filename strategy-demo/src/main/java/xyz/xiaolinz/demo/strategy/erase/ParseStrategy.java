package xyz.xiaolinz.demo.strategy.erase;

/**
 * 策略模式 - 消除if-else demo 解析策略
 *
 * @author huangmuhong
 * @version 1.0.0
 * @date 2024/02/05
 */
public interface ParseStrategy {

    /**
     * 解析
     *
     * @param content 内容
     * @return 解析结果
     */
    String parse(String content);
}
