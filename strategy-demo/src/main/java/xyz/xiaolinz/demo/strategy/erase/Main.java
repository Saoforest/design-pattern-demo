package xyz.xiaolinz.demo.strategy.erase;

/**
 * @author huangmuhong
 * @date 2024/2/5
 */
public class Main {
    public static void main(String[] args) {
        ParseContext parseContext = new ParseContext();
        parseContext.setParseStrategy("csv");
        System.out.println(parseContext.parse("content"));

        parseContext.setParseStrategy("json");
        System.out.println(parseContext.parse("content"));

        parseContext.setParseStrategy("xml");
        System.out.println(parseContext.parse("content"));
    }
}
