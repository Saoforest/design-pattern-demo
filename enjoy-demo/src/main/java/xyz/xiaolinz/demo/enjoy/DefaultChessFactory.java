package xyz.xiaolinz.demo.enjoy;

import java.util.ArrayList;
import java.util.List;
import xyz.xiaolinz.demo.enjoy.ChessPieceUnit.Color;

/**
 * 默认国际象棋享元工厂
 *
 * @author huangmuhong
 * @version 1.0.0
 * @date 2023/11/30
 * @see ChessFactory
 */
public class DefaultChessFactory implements ChessFactory {

    private final List<ChessPieceUnit> chessPieceUnits = new ArrayList<>();

    public DefaultChessFactory() {
        chessPieceUnits.add(new ChessPieceUnit(1, "車", Color.RED));
        chessPieceUnits.add(new ChessPieceUnit(2, "馬", Color.RED));
        chessPieceUnits.add(new ChessPieceUnit(3, "相", Color.RED));
        chessPieceUnits.add(new ChessPieceUnit(4, "仕", Color.RED));
        chessPieceUnits.add(new ChessPieceUnit(5, "帥", Color.RED));

        chessPieceUnits.add(new ChessPieceUnit(1, "車", Color.BLACK));
        chessPieceUnits.add(new ChessPieceUnit(2, "馬", Color.BLACK));
        chessPieceUnits.add(new ChessPieceUnit(3, "相", Color.BLACK));
        chessPieceUnits.add(new ChessPieceUnit(4, "仕", Color.BLACK));
        chessPieceUnits.add(new ChessPieceUnit(5, "帥", Color.BLACK));
    }

    @Override
    public ChessPieceUnit getChessPiece(int id, Color color) {
        return chessPieceUnits.stream()
            .filter(chessPieceUnit -> chessPieceUnit.getId() == id && chessPieceUnit.getColor() == color).findFirst()
            .orElseThrow(() -> new RuntimeException("未找到棋子"));
    }
}
