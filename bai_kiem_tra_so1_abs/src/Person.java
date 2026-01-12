import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private String address;
    List<Vehicle> vehicleList = new ArrayList<>();

    public Person(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public void addVehicle(Vehicle vehicle) {
        this.vehicleList.add(vehicle);
    }

    public void removeVehicle(String registrationNumber) {
        vehicleList.removeIf(vehicle -> vehicle.registrationNumber.equals(registrationNumber));
    }

    /**
     * Lấy thông tin chi tiết về tất cả các phương tiện mà người này sở hữu.
     * Nếu người này không có phương tiện nào, hàm sẽ trả về chuỗi thông báo tương ứng.
     *
     * @return chuỗi chứa thông tin các phương tiện, hoặc thông báo nếu không có phương tiện nào
     */
    public String getVehiclesInfo() {
        if (vehicleList.isEmpty()) {
            return getName() + " has no vehicle!";
        }

        StringBuilder sb = new StringBuilder();
        sb.append(name).append(" has:\n\n");

        for (Vehicle v : vehicleList) {
            if (v instanceof Car) {
                Car car = (Car) v;
                sb.append(car.getInfo()).append("\n");
            } else if (v instanceof MotorBike) {
                MotorBike bike = (MotorBike) v;
                sb.append(bike.getInfo()).append("\n");
            }

        }

        return sb.toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
