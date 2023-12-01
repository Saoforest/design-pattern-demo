package xyz.xiaolinz.demo.enjoy;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 享元模式 - 抽象出来的棋子享元，通过享元工厂获取
 *
 * @author huangmuhong
 * @version 1.0.0
 * @date 2023/11/30
 */
@AllArgsConstructor
@Data

public class ChessPieceUnit {

    private Integer id;

    private String text;

    private Color color;

    /**
     * 颜色
     *
     * @author huangmuhong
     * @version 1.0.0
     * @date 2023/11/30
     * @see Enum
     */
    public enum Color {
        RED, BLACK
    }

}
