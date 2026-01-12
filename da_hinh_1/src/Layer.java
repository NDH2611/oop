import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;


/**
 * Lớp {@code Layer} đại diện cho một lớp (layer) chứa nhiều đối tượng hình học {@link Shape}.
 * Lớp này cho phép thêm hình, xóa hình tròn, loại bỏ hình trùng lặp và
 * xuất thông tin của toàn bộ các hình trong layer.
 *
 */
public class Layer {
    private List<Shape> shapes = new ArrayList<>();

    /**
     * Thêm một hình vào layer.
     *
     * @param shape hình cần thêm vào; nếu {@code null} thì sẽ không thêm.
     */
    public void addShape(Shape shape) {
        if (shape != null) {
            shapes.add(shape);
        }
    }

    /**
     * Xóa tất cả các hình tròn ({@link Circle}) khỏi layer.
     * Sử dụng biểu thức lambda {@code removeIf} để lọc và xóa trực tiếp trong danh sách.
     */
    public void removeCircles() {
        /*
        for (Shape shape : shapes) {
            if (shape instanceof Circle) {
                shapes.remove(shape);
            }
        }

         */
        shapes.removeIf(shape -> shape instanceof Circle); //biểu thức lamda
    }

    /**
     * Lấy thông tin chi tiết của tất cả các hình trong layer dưới dạng chuỗi.
     *
     * @return chuỗi mô tả layer, bao gồm danh sách tất cả các hình và thông tin của chúng.
     */
    public String getInfo() {
        StringBuilder info = new StringBuilder("Layer of crazy shapes:\n");
        for (Shape shape : shapes) {
            info.append(shape.toString()).append("\n");
        }
        return info.toString();
    }

    /**
     * Loại bỏ các hình trùng lặp trong layer, chỉ giữ lại một bản duy nhất của mỗi hình.
     * Phương thức này sử dụng {@link LinkedHashSet} để loại trùng vừa giữ nguyên thứ tự ban đầu.
     */
    public void removeDuplicates() {
        /*
        for (int i = 0; i < shapes.size() - 1; i++) {
            for (int j = i + 1; j < shapes.size() - 1; j++) {
                if (shapes.get(i).equals(shapes.get(j))) {
                    shapes.remove(j);
                }
            }
        }
         */

        Set<Shape> set = new LinkedHashSet<>(shapes);
        shapes.clear();
        shapes.addAll(set);
    }
}
