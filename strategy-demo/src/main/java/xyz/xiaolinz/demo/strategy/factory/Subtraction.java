package xyz.xiaolinz.demo.strategy.factory;

/**
 * 策略模式demo - 计算器 减法具体策略
 *
 * @author huangmuhong
 * @version 1.0.0
 * @date 2024/02/04
 * @see Calculation
 */
public class Subtraction implements Calculation {
    @Override
    public double doCalculation(double num1, double num2) {
        return num1 - num2;
    }
}
