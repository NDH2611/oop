import java.util.ArrayList;
/**
 * Lớp Account mô tả tài khoản ngân hàng, có thể nạp và rút tiền.
 */

public class Account {
    private double balance;
    private ArrayList<Transaction> transitionList = new ArrayList<>();

    /**
     * Nạp tiền.
     *
     * @param amount số tiền nạp
     */
    private void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
        } else {
            System.out.printf("So tien ban nap vao khong hop le!");
        }
        transitionList.add(new Transaction(Transaction.DEPOSIT, amount, balance));
    }

    /**
     * Rút tiền.
     *
     * @param amount số tiền rút
     */
    private void withdraw(double amount) {
        if (amount > 0) {
            if (amount > balance) {
                System.out.println("So tien ban rut vuot qua so du!");
            } else {
                this.balance -= amount;
            }
        } else {
            System.out.println("So tien ban rut ra khong hop le!");
        }
        transitionList.add(new Transaction(Transaction.WITHDRAW, amount, balance));
    }

    /**
     * Thêm một giao dịch mới (nạp hoặc rút).
     *
     * @param amount    số tiền giao dịch
     * @param operation loại giao dịch ("deposit" hoặc "withdraw")
     */
    public void addTransaction(double amount, String operation) {
        if (operation.equals(Transaction.DEPOSIT)) {
            deposit(amount);
        } else if (operation.equals(Transaction.WITHDRAW)) {
            withdraw(amount);
        } else {
            System.out.println("Yeu cau khong hop le!");
        }
    }

    /**
     * In ra danh sách các giao dịch.
     */
    public void printTransaction() {
        int index = 1;
        for (Transaction transaction : transitionList) {
            if (transaction.getOperation().equals(Transaction.DEPOSIT)) {
                System.out.printf("Giao dich %d: Nap tien $%.2f. So du luc nay: $%.2f.\n",
                        index, transaction.getAmount(), transaction.getBalance());
            } else {
                System.out.printf("Giao dich %d: Rut tien $%.2f. So du luc nay: $%.2f.\n",
                        index, transaction.getAmount(), transaction.getBalance());
            }
            index++;
        }
    }
}
