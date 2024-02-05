package xyz.xiaolinz.demo.strategy.erase;

/**
 * @author huangmuhong
 * @date 2024/2/5
 */
public class XmlParseStrategy implements ParseStrategy {
    @Override
    public String parse(String content) {
        return "xml parse: " + content;
    }
}
