public class Move {
    private Piece movedPiece;
    private int startX;
    private int startY;
    private int endX;
    private int endY;
    private Piece killedPiece;

    /**
     * Tạo một nước đi không có việc ăn quân.
     *
     * @param startX tọa độ X
     * @param startY tọa độ Y
     * @param endX tọa độ X sau
     * @param endY tọa độ Y sau
     * @param movedPiece quân cờ được di chuyển
     */
    public Move(int startX, int endX, int startY, int endY, Piece movedPiece) {
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
        this.movedPiece = movedPiece;
    }

    /**
     * Tạo một nước đi có ăn quân.
     *
     * @param startX tọa độ X
     * @param startY tọa độ Y
     * @param endX tọa độ X sau
     * @param endY tọa độ Y sau
     * @param movedPiece quân cờ được di chuyển
     * @param killedPiece quân cờ bị ăn
     */
    public Move(int startX, int endX, int startY, int endY, Piece movedPiece, Piece killedPiece) {
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
        this.movedPiece = movedPiece;
        this.killedPiece = killedPiece;
    }

    private String moveCol(int x) {
        if (x == 1) {
            return "a";
        }
        if (x == 2) {
            return "b";
        }
        if (x == 3) {
            return "c";
        }
        if (x == 4) {
            return "d";
        }
        if (x == 5) {
            return "e";
        }
        if (x == 6) {
            return "f";
        }
        if (x == 7) {
            return "g";
        }
        return "h";
    }

    @Override
    public String toString() {
        return movedPiece.getColor()
                + "-"
                + movedPiece.getSymbol()
                + moveCol(endX)
                + endY;
    }

    public Piece getMovedPiece() {
        return movedPiece;
    }

    public void setMovedPiece(Piece movedPiece) {
        this.movedPiece = movedPiece;
    }

    public int getStartX() {
        return startX;
    }

    public void setStartX(int startX) {
        this.startX = startX;
    }

    public int getStartY() {
        return startY;
    }

    public void setStartY(int startY) {
        this.startY = startY;
    }

    public int getEndX() {
        return endX;
    }

    public void setEndX(int endX) {
        this.endX = endX;
    }

    public int getEndY() {
        return endY;
    }

    public void setEndY(int endY) {
        this.endY = endY;
    }

    public Piece getKilledPiece() {
        return killedPiece;
    }

    public void setKilledPiece(Piece killedPiece) {
        this.killedPiece = killedPiece;
    }
}
