package xyz.xiaolinz.demo.enjoy;

/**
 * @author huangmuhong
 * @date 2023/11/30
 */
public class Main {
    public static void main(String[] args) {
        final Checkerboard checkerboard = new Checkerboard();
        final ChessFactory defaultChessFactory = new DefaultChessFactory();
        checkerboard.putChessPiece(new Coordinates(1, 1),
            defaultChessFactory.getChessPiece(1, ChessPieceUnit.Color.RED));
        checkerboard.putChessPiece(new Coordinates(1, 2),
            defaultChessFactory.getChessPiece(2, ChessPieceUnit.Color.RED));
        checkerboard.putChessPiece(new Coordinates(1, 3),
            defaultChessFactory.getChessPiece(3, ChessPieceUnit.Color.RED));
        checkerboard.putChessPiece(new Coordinates(1, 4),
            defaultChessFactory.getChessPiece(4, ChessPieceUnit.Color.RED));
        checkerboard.putChessPiece(new Coordinates(1, 5),
            defaultChessFactory.getChessPiece(5, ChessPieceUnit.Color.RED));
        checkerboard.putChessPiece(new Coordinates(2, 1),
            defaultChessFactory.getChessPiece(1, ChessPieceUnit.Color.BLACK));
        checkerboard.putChessPiece(new Coordinates(2, 2),
            defaultChessFactory.getChessPiece(2, ChessPieceUnit.Color.BLACK));
        checkerboard.putChessPiece(new Coordinates(2, 3),
            defaultChessFactory.getChessPiece(3, ChessPieceUnit.Color.BLACK));
        checkerboard.putChessPiece(new Coordinates(2, 4),
            defaultChessFactory.getChessPiece(4, ChessPieceUnit.Color.BLACK));
        checkerboard.putChessPiece(new Coordinates(2, 5),
            defaultChessFactory.getChessPiece(5, ChessPieceUnit.Color.BLACK));
        checkerboard.display();
    }
}
