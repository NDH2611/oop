public class Bishop extends Piece {
    public Bishop(int coordinatesX, int coordinatesY) {
        super(coordinatesX, coordinatesY);
    }

    public Bishop(int coordinatesX, int coordinatesY, String color) {
        super(coordinatesX, coordinatesY, color);
    }

    @Override
    public String getSymbol() {
        return "B";
    }

    @Override
    public boolean canMove(Board board, int x, int y) {
        if (board.validate(x, y)) {
            if (Math.abs(getCoordinatesX() - x) == Math.abs(getCoordinatesY() - y)) {
                for (Piece piece : board.getPieces()) {
                    if (Math.min(x, getCoordinatesX()) < piece.getCoordinatesX()
                            && piece.getCoordinatesX() < Math.max(x, getCoordinatesX())
                            && Math.min(y, getCoordinatesY()) < piece.getCoordinatesY()
                            && piece.getCoordinatesY() < Math.max(y, getCoordinatesY())
                            && Math.abs(piece.getCoordinatesX() - x)
                            == Math.abs(piece.getCoordinatesY() - y)) {
                        return false;
                    }
                }
                if (board.getAt(x, y) == null) {
                    return true;
                } else {
                    return (!board.getAt(x, y).getColor().equals(this.getColor()));
                }
            }
        }
        return false;
    }
}
