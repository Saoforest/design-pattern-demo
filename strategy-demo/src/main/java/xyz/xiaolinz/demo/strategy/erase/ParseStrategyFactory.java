package xyz.xiaolinz.demo.strategy.erase;

import java.util.Map;

/**
 * 解析策略工厂
 *
 * @author huangmuhong
 * @version 1.0.0
 * @date 2024/02/05
 */

public class ParseStrategyFactory {

    public static final ParseStrategyFactory INSTANCE = new ParseStrategyFactory();

    private static final Map<String, ParseStrategy> parseStrategyMap =
        Map.of("json", new JsonParseStrategy(), "xml", new XmlParseStrategy(), "csv", new CsvParseStrategy());

    private ParseStrategyFactory() {
    }

    /**
     * 获取解析策略
     *
     * @param type 类型
     * @return {@link ParseStrategy }
     * @author huangmuhong
     * @date 2024/02/05
     * @since 1.0.0
     */
    public ParseStrategy getParseStrategy(String type) {
        return parseStrategyMap.get(type);
    }
}
