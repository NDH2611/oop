public class Rook extends Piece {
    public Rook(int coordinatesX, int coordinatesY) {
        super(coordinatesX, coordinatesY);
    }

    public Rook(int coordinatesX, int coordinatesY, String color) {
        super(coordinatesX, coordinatesY, color);
    }

    @Override
    public String getSymbol() {
        return "R";
    }

    @Override
    public boolean canMove(Board board, int x, int y) {
        if (!board.validate(x, y)) {
            return false;
        }

        if (this.getCoordinatesX() == x && this.getCoordinatesY() == y) {
            return false;
        }

        if (this.getCoordinatesX() != x && this.getCoordinatesY() != y) {
            return false;
        }

        if (board.getAt(x, y) != null
                && board.getAt(x, y).getColor().equals(this.getColor())) {
            return false;
        }
        if (y == getCoordinatesY()) {
            for (int moveX = Math.min(this.getCoordinatesX(), x) + 1;
                 moveX <= Math.max(this.getCoordinatesX(), x) - 1; ++moveX) {
                if (board.getAt(moveX, y) != null) {
                    return false;
                }
            }
        }

        if (x == getCoordinatesX()) {
            for (int moveY = Math.min(this.getCoordinatesY(), y) + 1;
                 moveY <= Math.max(this.getCoordinatesY(), y) - 1; ++moveY) {
                if (board.getAt(x, moveY) != null) {
                    return false;
                }
            }
        }

        return true;
    }
}
