package xyz.xiaolinz.demo.template;

/**
 * 抽象模板
 *
 * @author huangmuhong
 * @version 1.0.0
 * @date 2024/01/08
 */
public abstract class AbstractTemplate {

    /**
     * 定义算法骨架
     *
     * @author huangmuhong
     * @date 2024/01/08
     * @since 1.0.0
     */
    public final void algorithm() {
        // 执行具体步骤
        step1();
        step2();
        step3();
    }

    // 抽象方法必须由子类实现,部分步骤由模板类实现
    protected void step3() {
        System.out.println("AbstractTemplate.step3");
    }

    /**
     * 第2步
     *
     * @author huangmuhong
     * @date 2024/01/25
     * @since 1.0.0
     */
    protected abstract void step2();

    /**
     * 步骤1
     *
     * @author huangmuhong
     * @date 2024/01/25
     * @since 1.0.0
     */
    protected abstract void step1();

}
