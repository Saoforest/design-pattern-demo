package xyz.xiaolinz.demo.strategy.calculator;

/**
 * 策略模式demo - 计算器 上下文类
 *
 * @author huangmuhong
 * @version 1.0.0
 * @date 2024/02/04
 */
public class Calculator {

    private Calculation calculation;

    public void setCalculation(Calculation calculation) {
        this.calculation = calculation;
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
