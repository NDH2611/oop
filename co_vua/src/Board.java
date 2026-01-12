import java.util.ArrayList;

public class Board {
    public static final int WIDTH = 8;
    public static final int HEIGHT = 8;
    private ArrayList<Piece> pieces = new ArrayList<>();

    public ArrayList<Piece> getPieces() {
        return pieces;
    }

    public void setPieces(ArrayList<Piece> pieces) {
        this.pieces = pieces;
    }

    /**
     * Lấy quân cờ tại tọa độ chỉ định.
     *
     * @param x tọa độ X cần kiểm tra
     * @param y tọa độ Y cần kiểm tra
     * @return quân cờ tại vị trí (x, y) nếu tồn tại
     */
    public Piece getAt(int x, int y) {
        for (Piece piece : pieces) {
            if (x == piece.getCoordinatesX() && y == piece.getCoordinatesY()) {
                return piece;
            }
        }
        return null;
    }

    public boolean validate(int x, int y) {
        return (1 <= x && x <= 8 && 1 <= y && y <= 8);
    }

    /**
     * Thêm một quân cờ vào bàn nếu vị trí hợp lệ và chưa có quân khác tại đó.
     *
     * @param piece quân cờ cần thêm
     */
    public void addPiece(Piece piece) {
        if (!validate(piece.getCoordinatesX(), piece.getCoordinatesY())) {
            return;
        }

        if (getAt(piece.getCoordinatesX(), piece.getCoordinatesY()) != null) {
            return;
        }

        this.pieces.add(piece);
    }

    /**
     * Xóa quân cờ tại vị trí chỉ định nếu tồn tại.
     *
     * @param x tọa độ X cần xóa
     * @param y tọa độ Y cần xóa
     */
    public void removeAt(int x, int y) {
        Piece piece = getAt(x, y);
        if (piece != null) {
            this.pieces.remove(piece);
        }
    }
}
