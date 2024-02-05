package xyz.xiaolinz.demo.strategy.factory;

/**
 * 主要
 *
 * @author huangmuhong
 * @version 1.0.0
 * @date 2024/02/05
 */
public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.setCalculation("addition");
        System.out.println("1 + 2 = " + calculator.compute(1, 2));
        calculator.setCalculation("subtraction");
        System.out.println("1 - 2 = " + calculator.compute(1, 2));
    }
}
