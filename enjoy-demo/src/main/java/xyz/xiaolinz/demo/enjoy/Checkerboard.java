package xyz.xiaolinz.demo.enjoy;

import java.util.HashMap;
import java.util.Map;

/**
 * 享元模式 - 客户端角色
 *
 * @author huangmuhong
 * @version 1.0.0
 * @date 2023/11/30
 */
public class Checkerboard {

    private final Map<Coordinates, ChessPieceUnit> chessPieces = new HashMap<>();

    public void display() {
        for (Map.Entry<Coordinates, ChessPieceUnit> entry : chessPieces.entrySet()) {
            System.out.println(entry.getKey() + "-->" + entry.getValue());

        }
    }

    /**
     * 放棋子
     *
     * @param coordinates    坐标
     * @param chessPieceUnit 棋子单位
     * @author huangmuhong
     * @date 2023/11/30
     * @since 1.0.0
     */
    public void putChessPiece(Coordinates coordinates, ChessPieceUnit chessPieceUnit) {
        chessPieces.put(coordinates, chessPieceUnit);
    }

    /**
     * 得到棋子
     *
     * @param coordinates 坐标
     * @return {@link ChessPieceUnit }
     * @author huangmuhong
     * @date 2023/11/30
     * @since 1.0.0
     */
    public ChessPieceUnit getChessPiece(Coordinates coordinates) {
        return chessPieces.get(coordinates);
    }

}
