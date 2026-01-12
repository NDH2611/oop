import java.util.Objects;

public class Rectangle extends Shape {
    protected Point topLeft;
    protected double width;
    protected double length;

    /**
     * Khởi tạo đối tượng Rectangle.
     *
     */

    public Rectangle() {
    }

    /**
     * Khởi tạo đối tượng Rectangle.
     *
     * @param width  chiều dài
     * @param length   chiều rộng
     */
    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    /**
     * Khởi tạo đối tượng Rectangle.
     *
     * @param width  chiều dài
     * @param length   chiều rộng
     * @param color    màu
     * @param filled  tô
     */
    public Rectangle(double width, double length, String color, boolean filled) {
        super(color, filled);
        this.width = width;
        this.length = length;
    }

    /**
     * Khởi tạo đối tượng Rectangle.
     *
     * @param width  chiều dài
     * @param length   chiều rộng
     * @param color    màu
     * @param filled  tô
     * @param topLeft điểm trái trên
     */
    public Rectangle(Point topLeft, double width, double length, String color, boolean filled) {
        super(color, filled);
        this.topLeft = topLeft;
        this.width = width;
        this.length = length;
    }

    public Point getTopLeft() {
        return topLeft;
    }

    public void setTopLeft(Point topLeft) {
        this.topLeft = topLeft;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    @Override
    public double getArea() {
        return width * length;
    }

    @Override
    public double getPerimeter() {
        return 2 * (width + length);
    }

    @Override
    public String toString() {
        return String.format("Rectangle[topLeft=%s,width=%.1f,length=%.1f,color=%s,filled=%b]",
                topLeft, width, length, getColor(), isFilled());
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Rectangle) {
            Rectangle r = (Rectangle) o;
            return Math.abs(length - r.length) <= 0.001 && Math.abs(width - r.width) <= 0.001
                    && topLeft.equals(r.topLeft);
        }
        return false;
    }

    public  int hashCode() {
        return Objects.hash(topLeft, width, length);
    }
}
