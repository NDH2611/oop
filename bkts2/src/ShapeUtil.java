import java.util.List;

public class ShapeUtil {
    /**
     * Tạo chuỗi thông tin chứa danh sách các hình.
     *
     * @param shapes danh sách các đối tượng hình học cần in thông tin.
     * @return chuỗi thông tin đã được kết hợp theo nhóm hình.
     */
    public String printInfo(List<GeometricObject> shapes) {
        StringBuilder info = new StringBuilder();
        info.append("Circle:\n");
        for (GeometricObject shape : shapes) {
            if (shape instanceof Circle) {
                info.append(shape.getInfo()).append("\n");
            }
        }
        info.append("Triangle:\n");
        for (GeometricObject shape : shapes) {
            if (shape instanceof Triangle) {
                info.append(shape.getInfo()).append("\n");
            }
        }
        return info.toString();
    }
}
