package xyz.xiaolinz.demo.strategy.factory;

/**
 * 计算器demo 策略模式 - 策略接口
 *
 * @author huangmuhong
 * @version 1.0.0
 * @date 2024/02/04
 */
public interface Calculation {

    /**
     * 做计算
     *
     * @param num1
     * @param num2
     * @return double
     * @author huangmuhong
     * @date 2024/02/04
     * @since 1.0.0
     */
    double doCalculation(double num1, double num2);

}
