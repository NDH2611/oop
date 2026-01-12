public abstract class Piece {
    private int coordinatesX;
    private int coordinatesY;
    private String color;

    /**
     * Tạo một quân cờ tại vị trí xác định và có màu mặc định là trắng.
     *
     * @param coordinatesX tọa độ X của quân cờ
     * @param coordinatesY tọa độ Y của quân cờ
     */
    public Piece(int coordinatesX, int coordinatesY) {
        this.coordinatesX = coordinatesX;
        this.coordinatesY = coordinatesY;
        this.color = "white";
    }

    /**
     * Tạo một quân cờ tại vị trí xác định với màu được chỉ định.
     *
     * @param coordinatesX tọa độ X của quân cờ
     * @param coordinatesY tọa độ Y của quân cờ
     * @param color        màu của quân cờ ("white" hoặc "black")
     */
    public Piece(int coordinatesX, int coordinatesY, String color) {
        this.coordinatesX = coordinatesX;
        this.coordinatesY = coordinatesY;
        if (!"black".equals(color)) {
            color = "white";
        }
        this.color = color;
    }

    public int getCoordinatesX() {
        return coordinatesX;
    }

    public void setCoordinatesX(int coordinatesX) {
        this.coordinatesX = coordinatesX;
    }

    public int getCoordinatesY() {
        return coordinatesY;
    }

    public void setCoordinatesY(int coordinatesY) {
        this.coordinatesY = coordinatesY;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public abstract String getSymbol();

    public abstract boolean canMove(Board board, int x, int y);

    public boolean checkPosition(Piece piece) {
        return true;
    }
}

