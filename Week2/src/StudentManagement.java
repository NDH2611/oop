/**
 *  Quản lí sinh viên thêm, bớt, nhóm, in.
 */
public class StudentManagement {
    private Student[] students;
    private int count;

    /**
     * Constructor khởi tạo danh sách rỗng với sức chứa 100 sinh viên.
     */
    public StudentManagement() {
        students = new Student[100];
        count = 0;
    }

    /**
     * So sánh hai sinh viên có cùng lớp hay không.
     * @param s1 sinh viên thứ nhất
     * @param s2 sinh viên thứ hai
     * @return true nếu cùng lớp, false nếu khác
     */
    public static boolean sameGroup(Student s1, Student s2) {
        return s1.getGroup().equals(s2.getGroup());
    }

    /**
     * Thêm một sinh viên mới vào danh sách.
     * @param newStudent sinh viên cần thêm
     */
    public void addStudent(Student newStudent) {
        if (count < students.length) {
            students[count] = newStudent;
            count++;
        }
    }

    /**
     * Gom và in danh sách sinh viên theo lớp.
     * @return chuỗi các nhóm sinh viên theo lớp
     */
    public String studentsByGroup() {
        StringBuilder result = new StringBuilder();
        boolean[] printed = new boolean[count];
        for (int i = 0; i < count; i++) {
            if (!printed[i]) {
                String group = students[i].getGroup();
                result.append(group).append("\n");
                for (int j = 0; j < count; j++) {
                    if (!printed[j] && students[j].getGroup().equals(group)) {
                        result.append(students[j].getInfo()).append("\n");
                        printed[j] = true;
                    }
                }
            }
        }
        return result.toString();
    }

    /**
     * Xóa sinh viên theo mã số.
     * @param id mã số sinh viên cần xóa
     */
    public void removeStudent(String id) {
        for (int i = 0; i < count; i++) {
            if (students[i].getId().equals(id)) {
                for (int j = i; j < count - 1; j++) {
                    students[j] = students[j + 1];
                }
                students[count - 1] = null;
                count--;
                return;
            }
        }
    }

}

