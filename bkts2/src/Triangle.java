public class Triangle implements GeometricObject {
    private Point p1;
    private Point p2;
    private Point p3;

    /**
     * Tạo một tam giác từ ba điểm cho trước.
     *
     * @param p1 điểm thứ nhất của tam giác
     * @param p2 điểm thứ hai của tam giác
     * @param p3 điểm thứ ba của tam giác
     * @throws RuntimeException nếu ba điểm không thể tạo thành một tam giác
     */
    public Triangle(Point p1, Point p2, Point p3) throws RuntimeException {
        if (p1.equals(p2) || p2.equals(p3) || p3.equals(p1)) {
            throw new RuntimeException();
        }

        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;

        if (this.getArea() == 0) {
            throw new RuntimeException();
        }
    }

    public Point getP1() {
        return p1;
    }

    public Point getP2() {
        return p2;
    }

    public Point getP3() {
        return p3;
    }

    @Override
    public double getArea() {
        return Math.abs((p2.getPointX() - p1.getPointX()) * (p2.getPointY() + p1.getPointY())
                + (p3.getPointX() - p2.getPointX()) * (p3.getPointY() + p2.getPointY())
                + (p1.getPointX() - p3.getPointX()) * (p3.getPointY() + p1.getPointY())) / 2.0;
    }

    @Override
    public double getPerimeter() {
        return p1.distance(p2) + p2.distance(p3) + p3.distance(p1);
    }

    @Override
    public String getInfo() {
        return String.format("Triangle[(%.2f,%.2f),(%.2f,%.2f),(%.2f,%.2f)]",
                p1.getPointX(), p1.getPointY(), p2.getPointX(), p2.getPointY(),
                p3.getPointX(), p3.getPointY());
    }
}
