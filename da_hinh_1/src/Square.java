/**
 * Lớp {@code Square} mô tả hình vuông,
 * kế thừa từ lớp {@link Rectangle}.
 * Đảm bảo hai cạnh (chiều dài và chiều rộng) luôn bằng nhau.
 */
public class Square extends Rectangle {

    /**
     * Khởi tạo đối tượng {@code Square} mặc định
     * với cạnh = 0.0, không màu, không tô.
     */
    public Square() {
    }

    /**
     * Khởi tạo đối tượng {@code Square} với độ dài cạnh cho trước.
     *
     * @param side độ dài cạnh của hình vuông
     */
    public Square(double side) {
        super(side, side);
    }

    /**
     * Khởi tạo đối tượng {@code Square} với độ dài cạnh, màu sắc và trạng thái tô.
     *
     * @param side   độ dài cạnh của hình vuông
     * @param color  màu của hình vuông
     * @param filled trạng thái tô màu (true nếu có tô)
     */
    public Square(double side, String color, boolean filled) {
        super(side, side, color, filled);
    }

    public Square(Point topLeft, double side, String color, boolean filled) {
        super(topLeft, side, side, color, filled);
    }

    /**
     * Trả về độ dài cạnh của hình vuông.
     *
     * @return độ dài cạnh
     */
    public double getSide() {
        return getWidth();
    }

    /**
     * Cập nhật độ dài cạnh của hình vuông (cập nhật đồng thời chiều rộng và chiều dài).
     *
     * @param side độ dài cạnh mới
     */
    public void setSide(double side) {
        super.setWidth(side);
        super.setLength(side);
    }

    /**
     * Ghi đè phương thức {@code setWidth} để đảm bảo hình vuông luôn có cạnh bằng nhau.
     *
     * @param side độ dài cạnh mới
     */
    @Override
    public void setWidth(double side) {
        super.setWidth(side);
        super.setLength(side);
    }

    /**
     * Ghi đè phương thức {@code setLength} để đảm bảo hình vuông luôn có cạnh bằng nhau.
     *
     * @param side độ dài cạnh mới
     */
    @Override
    public void setLength(double side) {
        super.setLength(side);
        super.setWidth(side);
    }

    /**
     * Trả về chuỗi mô tả đối tượng hình vuông.
     *
     * @return chuỗi dạng: {@code Square[side=...,color=...,filled=...]}
     */
    @Override
    public String toString() {
        return String.format("Square[topLeft=%s,side=%.1f,color=%s,filled=%b]",
                 topLeft, getSide(), getColor(), isFilled());
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Square) {
            Square s = (Square) o;
            return super.equals(s) && Math.abs(getSide() - s.getSide()) <= 0.001;
        }
        return false;
    }

    public int hashCode() {
        return super.hashCode();
    }
}
