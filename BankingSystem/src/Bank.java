import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Bank {
    private List<Customer> customerList = new ArrayList<>();

    /**
     * Đọc danh sách khách hàng từ InputStream.
     *
     * @param inputStream luồng dữ liệu chứa thông tin khách hàng
     */
    public void readCustomerList(InputStream inputStream) {
        Scanner scanner = new Scanner(inputStream);
        Customer customer = null;
        while (scanner.hasNextLine()) {
            String read = scanner.nextLine();
            if (Character.isDigit(read.charAt(0))) {
                int pos1 = read.indexOf(' ');
                int pos2 = read.lastIndexOf(' ');

                if (read.substring(pos1 + 1, pos2).equals(Account.CHECKING)) {
                    customer.addAccount(new CheckingAccount(Long.parseLong(read.substring(0, pos1)),
                            Double.parseDouble(read.substring(pos2 + 1))));
                } else {
                    customer.addAccount(new SavingsAccount(Long.parseLong(read.substring(0, pos1)),
                            Double.parseDouble(read.substring(pos2 + 1))));
                }
            } else {
                if (customer != null && customer.getFullName() != null
                        && !customer.getFullName().isEmpty()) {
                    customerList.add(customer);
                }
                /*
                if (!customer.getFullName().isEmpty()) {
                    customerList.add(customer);
                }
                 */
                int position = read.lastIndexOf(' ');
                customer = new Customer(Long.parseLong(read.substring(position + 1)),
                        read.substring(0, position));
            }
        }

        if (customer != null && customer.getFullName() != null
                && !customer.getFullName().isEmpty()) {
            customerList.add(customer);
        }
    }

    /**
     * Trả về thông tin khách hàng theo thứ tự tên.
     *
     * @return thông tin khách hàng sắp xếp theo tên
     */
    public String getCustomersInfoByNameOrder() {
        StringBuilder res = new StringBuilder();
        Collections.sort(customerList, new Comparator<Customer>() {
            @Override
            public int compare(Customer x, Customer y) {
                return x.getFullName().compareTo(y.getFullName());
            }
        });
        for (int i = 0; i < customerList.size(); ++i) {
            Customer customer = customerList.get(i);
            res.append(customer.getCustomerInfo());
            if (i != customerList.size() - 1) {
                res.append("\n");
            }
        }
        return res.toString();
    }

    /**
     * Trả về thông tin khách hàng theo thứ tự ID.
     *
     * @return thông tin khách hàng sắp xếp theo ID
     */
    public String getCustomersInfoByIdOrder() {
        StringBuilder res = new StringBuilder();
        Collections.sort(customerList, new Comparator<Customer>() {
            @Override
            public int compare(Customer x, Customer y) {
                return x.getIdNumber() < y.getIdNumber() ? -1 : 1;
            }
        });
        for (int i = 0; i < customerList.size(); ++i) {
            Customer customer = customerList.get(i);
            res.append(customer.getCustomerInfo());
            if (i != customerList.size() - 1) {
                res.append("\n");
            }
        }
        return res.toString();
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }
}
