package xyz.xiaolinz.demo.strategy.factory;

/**
 * 策略模式demo - 计算器 上下文类
 *
 * @author huangmuhong
 * @version 1.0.0
 * @date 2024/02/04
 */
public class Calculator {

    private final CalculationFactory calculationFactory = new CalculationFactory();

    private Calculation calculation;

    /**
     * 设定计算策略
     *
     * @param calculationType 计算类型
     * @author huangmuhong
     * @date 2024/02/05
     * @since 1.0.0
     */
    public void setCalculation(String calculationType) {
        this.calculation = calculationFactory.getCalculationInstance(calculationType);
    }

    /**
     * 计算
     *
     * @param num1 数字1
     * @param num2 数字2
     * @return double
     * @author huangmuhong
     * @date 2024/02/04
     * @since 1.0.0
     */
    public double compute(double num1, double num2) {
        return calculation.doCalculation(num1, num2);
    }

}
