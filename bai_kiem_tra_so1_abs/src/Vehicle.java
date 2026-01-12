public abstract class Vehicle {
    protected String brand;
    protected String model;
    protected String registrationNumber;
    protected Person owner;

    /**
     * Tạo một đối tượng {@code Vehicle} mới với các thông tin cơ bản.
     *
     * @param brand               hãng sản xuất của phương tiện
     * @param model               mẫu xe của phương tiện
     * @param registrationNumber  biển số đăng ký của phương tiện
     * @param owner               chủ sở hữu của phương tiện
     */
    public Vehicle(String brand, String model, String registrationNumber, Person owner) {
        this.brand = brand;
        this.model = model;
        this.registrationNumber = registrationNumber;
        this.owner = owner;
    }

    public abstract String getInfo();

    public void transferOwnership(Person newOwner) {
        this.owner = newOwner;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }
}
