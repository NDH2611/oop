/**
 * Lưu các thông tin về student bao gồm name, id, group, email.
 */
public class Student {
    private String name;
    private String id;
    private String group;
    private String email;

    /**
     * Lấy tên sinh viên.
     * @return tên sinh viên
     */
    public String getName() {
        return name;
    }

    /**
     * Đặt tên sinh viên.
     * @param n tên mới
     */
    public void setName(String n) {
        this.name = n;
    }

    /**
     * Lấy mã số sinh viên.
     * @return mã số sinh viên
     */
    public String getId() {
        return id;
    }

    /**
     * Đặt mã số sinh viên.
     * @param n mã số mới
     */
    public void setId(String n) {
        this.id = n;
    }

    /**
     * Lấy lớp (group) của sinh viên.
     * @return lớp sinh viên
     */
    public String getGroup() {
        return group;
    }

    /**
     * Đặt lớp (group) cho sinh viên.
     * @param n tên lớp
     */
    public void setGroup(String n) {
        this.group = n;
    }

    /**
     * Lấy email của sinh viên.
     * @return email sinh viên
     */
    public String getEmail() {
        return email;
    }

    /**
     * Đặt email cho sinh viên.
     * @param n email mới
     */
    public void setEmail(String n) {
        this.email = n;
    }

    /**
     * Trả về thông tin sinh viên dạng chuỗi.
     * @return chuỗi gồm name - id - group - email
     */
    public String getInfo() {
        return getName() + " - " + getId() + " - " + getGroup() + " - " + getEmail();
    }

    /**
     * Constructor mặc định.
     */
    public Student() {
        this.name = "Student";
        this.id = "000";
        this.group = "K62CB";
        this.email = "uet@vnu.edu.vn";
    }

    /**
     * Constructor khởi tạo sinh viên với name, id, email.
     * @param name họ tên
     * @param id mã số sinh viên
     * @param email địa chỉ email
     */
    public Student(String name, String id, String email) {
        this.name = name;
        this.id = id;
        this.group = "K62CB";
        this.email = email;
    }

    /**
     * Constructor sao chép từ sinh viên khác.
     * @param s đối tượng Student cần sao chép
     */
    public Student(Student s) {
        name = s.name;
        id = s.id;
        group = s.group;
        email = s.email;
    }
}
