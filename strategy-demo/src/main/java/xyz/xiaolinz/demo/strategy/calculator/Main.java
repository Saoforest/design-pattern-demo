package xyz.xiaolinz.demo.strategy.calculator;

/**
 * 主要
 *
 * @author huangmuhong
 * @version 1.0.0
 * @date 2024/02/04
 */
public class Main {

    public static void main(String[] args) {

        // 定义需要计算的值
        double num1 = 100;
        double num2 = 200;

        // 创建策略上下文
        final Calculator calculator = new Calculator();
        // 设置具体的策略
        // step1. 加法
        calculator.setCalculation(new Addition());
        System.out.println("加法策略计算结果:" + calculator.compute(num1, num2));

        // step2. 减法
        calculator.setCalculation(new Subtraction());
        System.out.println("减法策略计算结果:" + calculator.compute(num1, num2));

        // step3. 乘法
        calculator.setCalculation(new Multiplication());
        System.out.println("乘法策略计算结果:" + calculator.compute(num1, num2));

        // step4. 除法
        calculator.setCalculation(new Division());
        System.out.println("除法策略计算结果:" + calculator.compute(num1, num2));
    }
}
