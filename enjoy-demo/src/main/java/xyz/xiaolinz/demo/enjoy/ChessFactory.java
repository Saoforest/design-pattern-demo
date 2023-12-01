package xyz.xiaolinz.demo.enjoy;

/**
 * 享元模式 - 享元工厂
 *
 * @author huangmuhong
 * @version 1.0.0
 * @date 2023/11/30
 */
public interface ChessFactory {

    /**
     * 获取棋子
     *
     * @param id    id
     * @param color 颜色
     * @return {@link ChessPieceUnit }
     * @author huangmuhong
     * @date 2023/11/30
     * @since 1.0.0
     */
    ChessPieceUnit getChessPiece(int id, ChessPieceUnit.Color color);

}
