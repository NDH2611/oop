import java.util.ArrayList;

public class Game {
    private Board board;
    private ArrayList<Move> moveHistory = new ArrayList<>();

    public Game(Board board) {
        this.board = board;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public ArrayList<Move> getMoveHistory() {
        return moveHistory;
    }

    /**
     * Di chuyển một quân cờ đến vị trí chỉ định nếu nước đi hợp lệ.
     *
     * @param piece quân cờ cần di chuyển
     * @param x     tọa độ X mới
     * @param y     tọa độ Y mới
     */
    public void movePiece(Piece piece, int x, int y) {
        if (piece == null) {
            return;
        }

        if (board == null) {
            return;
        }

        if (piece.canMove(board, x, y)) {
            Piece capturedPiece = board.getAt(x, y);

            if (capturedPiece != null) {
                board.removeAt(x, y);
            }

            int oldX = piece.getCoordinatesX();
            int oldY = piece.getCoordinatesY();
            piece.setCoordinatesX(x);
            piece.setCoordinatesY(y);
            Move move = new Move(oldX, x, oldY, y, piece, capturedPiece);
            moveHistory.add(move);
        }
    }
}

