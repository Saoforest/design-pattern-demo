package xyz.xiaolinz.demo.template;

/**
 * 实施模板a
 *
 * @author huangmuhong
 * @version 1.0.0
 * @date 2024/01/08
 * @see AbstractTemplate
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
