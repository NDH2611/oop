/**
 * Lớp mô tả một giao dịch (nạp tiền hoặc rút tiền).
 */

public class Transaction {
    private String operation;
    private double amount;
    private double balance;
    public static final String DEPOSIT = "deposit";
    public static final String WITHDRAW = "withdraw";

    /**
     * Khởi tạo một giao dịch mới.
     *
     * @param operation loại giao dịch (deposit hoặc withdraw)
     * @param amount    số tiền được giao dịch
     * @param balance   số dư
     */
    public Transaction(String operation, double amount, double balance) {
        this.operation = operation;
        this.balance = balance;
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }


}
