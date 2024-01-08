package xyz.xiaolinz.demo.template;

/**
 * @author huangmuhong
 * @date 2024/1/8
 */
public class Main {
    public static void main(String[] args) {
        AbstractTemplate template = new ImplementTemplateA();
        template.algorithm();
    }
}
