package xyz.xiaolinz.demo.strategy.erase;

/**
 * 解析上下文
 *
 * @author huangmuhong
 * @version 1.0.0
 * @date 2024/02/05
 */
public class ParseContext {

    private final ParseStrategyFactory parseStrategyFactory = ParseStrategyFactory.INSTANCE;

    private ParseStrategy parseStrategy;

    public void setParseStrategy(String type) {
        this.parseStrategy = parseStrategyFactory.getParseStrategy(type);
    }

    /**
     * 解析
     *
     * @param content 内容
     * @return 解析结果
     */
    public String parse(String content) {
        if (parseStrategy == null) {
            throw new RuntimeException("parse strategy is not set");
        }
        return parseStrategy.parse(content);
    }

}
