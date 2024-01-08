package xyz.xiaolinz.demo.template;

/**
 * @author huangmuhong
 * @date 2024/1/8
 */
public class ImplementTemplateA extends AbstractTemplate {
    @Override
    protected void step2() {
        System.out.println("ImplementTemplateA.step2");
    }

    @Override
    protected void step1() {
        System.out.println("ImplementTemplateA.step1");
    }
}
