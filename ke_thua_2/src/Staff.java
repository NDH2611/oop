public class Staff extends Person {
    private String school;
    private double pay;

    /**
     * Khởi tạo đối tượng Staff.
     *
     * @param name    tên nhân viên
     * @param address địa chỉ nhân viên
     * @param school  trường làm việc
     * @param pay     mức lương
     */
    public Staff(String name, String address, String school, double pay) {
        super(name, address);
        this.school = school;
        this.pay = pay;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public double getPay() {
        return pay;
    }

    public void setPay(double pay) {
        this.pay = pay;
    }

    @Override
    public String toString() {
        return "Staff[" + super.toString()
                + ",school=" + school
                + ",pay=" + pay + ']';
    }
}
