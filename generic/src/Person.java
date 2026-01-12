public class Person implements Comparable<Person> {
    protected String name;
    protected int age;
    protected String address;

    public Person() {
    }

    /**
     * Tạo một đối tượng {@code Person} với tên, tuổi và địa chỉ cụ thể.
     *
     * @param name    tên của người
     * @param age     tuổi của người
     * @param address địa chỉ của người
     */
    public Person(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * So sánh đối tượng {@code Person} hiện tại với một đối tượng khác.
     * <p>
     * Quy tắc so sánh:
     * <ul>
     *   <li>So sánh theo tên (tăng dần, theo thứ tự từ điển Unicode).</li>
     *   <li>Nếu tên giống nhau, so sánh tiếp theo tuổi (tăng dần).</li>
     * </ul>
     * </p>
     *
     * @param p đối tượng {@code Person} khác để so sánh
     * @return giá trị âm nếu đối tượng hiện tại nhỏ hơn {@code p},
     *         0 nếu bằng nhau, hoặc dương nếu lớn hơn
     */
    public int compareTo(Person p) {
        if (this.name.equals(p.name)) {
            return this.age - p.age;
        }
        return this.name.compareTo(p.name);
    }
}
