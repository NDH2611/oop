import java.util.Objects;

/**
 * Lớp {@code Circle} mô tả hình tròn,
 * kế thừa từ lớp {@link Shape}.
 * Lưu trữ thông tin về bán kính, màu sắc và trạng thái tô.
 */

public class Circle extends Shape {
    /** Bán kính của hình tròn. */
    protected Point center;
    protected double radius;

    /**
     * Khởi tạo đối tượng {@code Circle} mặc định
     * với bán kính = 0.0, không màu, không tô.
     */
    public Circle() {
    }

    /**
     * Khởi tạo đối tượng {@code Circle} với bán kính cho trước.
     *
     * @param radius bán kính của hình tròn
     */
    public Circle(double radius) {
        this.radius = radius;
    }

    /**
     * Khởi tạo đối tượng {@code Circle} với bán kính, màu sắc và trạng thái tô.
     *
     * @param radius bán kính của hình tròn
     * @param color  màu của hình tròn
     * @param filled trạng thái tô màu (true nếu có tô)
     */
    public Circle(double radius, String color, boolean filled) {
        super(color, filled);
        this.radius = radius;
    }

    /**
     * Khởi tạo đối tượng {@code Circle} với bán kính, màu sắc và trạng thái tô.
     *
     * @param radius bán kính của hình tròn
     * @param color  màu của hình tròn
     * @param filled trạng thái tô màu (true nếu có tô)
     * @param center trung tâm tròn
     */
    public Circle(Point center, double radius, String color, boolean filled) {
        super(color, filled);
        this.center = center;
        this.radius = radius;
    }

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    /**
     * Trả về bán kính của hình tròn.
     *
     * @return bán kính
     */
    public double getRadius() {
        return radius;
    }

    /**
     * Cập nhật bán kính của hình tròn.
     *
     * @param radius bán kính mới
     */
    public void setRadius(double radius) {
        this.radius = radius;
    }

    /**
     * Tính diện tích hình tròn.
     *
     * @return diện tích = π × r²
     */
    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    /**
     * Tính chu vi hình tròn.
     *
     * @return chu vi = 2 × π × r
     */
    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    /**
     * Trả về chuỗi mô tả đối tượng hình tròn.
     *
     * @return chuỗi dạng: {@code Circle[radius=...,color=...,filled=...]}
     */
    @Override
    public String toString() {
        return String.format("Circle[center=%s,radius=%.1f,color=%s,filled=%b]",
                center, radius, getColor(), isFilled());
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Circle) {
            Circle c = (Circle) o;
            return Math.abs(radius - c.radius) <= 0.001 && center.equals(c.center);
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(radius, center);
    }
}
