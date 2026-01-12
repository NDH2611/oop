import java.util.Objects;

public class Point {
    private double pointX;
    private double pointY;

    public Point(double pointX, double pointY) {
        this.pointX = pointX;
        this.pointY = pointY;
    }

    public double getPointX() {
        return pointX;
    }

    public void setPointX(double pointX) {
        this.pointX = pointX;
    }

    public double getPointY() {
        return pointY;
    }

    public void setPointY(double pointY) {
        this.pointY = pointY;
    }

    public double distance(Point newPoint) {
        return Math.sqrt((this.pointX -  newPoint.pointX) * (this.pointX -  newPoint.pointX)
        + (this.pointY -  newPoint.pointY) * (this.pointY -  newPoint.pointY));
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Point) {
            Point p = (Point) o;
            return this.pointX == p.pointX && this.pointY == p.pointY;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(pointX, pointY);
    }

    public String toString() {
        return "(" + pointX + "," + pointY + ')';
    }
}
