package xyz.xiaolinz.demo.template.callback;

/**
 * 主要
 *
 * @author huangmuhong
 * @version 1.0.0
 * @date 2024/01/08
 */
public class Main {
    public static void main(String[] args) {
        AClass aClass = new AClass();
        aClass.process(() -> System.out.println("AClass.process"));
    }
}
