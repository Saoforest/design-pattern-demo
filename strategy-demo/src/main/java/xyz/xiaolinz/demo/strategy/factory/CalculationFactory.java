package xyz.xiaolinz.demo.strategy.factory;

import java.util.HashMap;
import java.util.Map;

/**
 * 策略模式demo - 计算器工厂
 *
 * @author huangmuhong
 * @version 1.0.0
 * @date 2024/02/05
 */
public class CalculationFactory {

    private static final Map<String, Calculation> calculationMap = new HashMap<>();

    /**
     * 获取计算实例
     *
     * @param calculationType 计算类型
     * @return {@link Calculation }
     * @author huangmuhong
     * @date 2024/02/05
     * @since 1.0.0
     */
    public Calculation getCalculationInstance(String calculationType) {

        return calculationMap.getOrDefault(calculationType, createInstance(calculationType));

    }

    /**
     * 创建实例
     *
     * @param calculationType 计算类型
     * @return {@link Calculation }
     * @author huangmuhong
     * @date 2024/02/05
     * @since 1.0.0
     */
    private Calculation createInstance(String calculationType) {
        switch (calculationType) {
            case "addition":
                return new Addition();
            case "subtraction":
                return new Subtraction();
            case "multiplication":
                return new Multiplication();
            case "division":
                return new Division();
            default:
                throw new IllegalArgumentException("calculationType is not supported");
        }
    }

}
