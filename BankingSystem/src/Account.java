import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Account {
    public static final String CHECKING = "CHECKING";
    public static final String SAVINGS = "SAVINGS";
    protected long accountNumber;
    protected double balance;
    protected List<Transaction> transactionList = new ArrayList<>();

    public Account() {
    }

    public Account(long accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    /**
     * Thực hiện rút tiền với kiểm tra lỗi.
     *
     * @param amount số tiền muốn rút
     * @throws InvalidFundingAmountException nếu số tiền âm
     * @throws InsufficientFundsException   nếu số dư không đủ
     */
    public void doWithdrawing(double amount)
            throws InvalidFundingAmountException, InsufficientFundsException {
        if (amount < 0) {
            throw new InvalidFundingAmountException(amount);
        }

        if (amount > balance) {
            throw new InsufficientFundsException(amount);
        }

        balance -= amount;
    }

    /**
     * Thực hiện gửi tiền với kiểm tra lỗi.
     *
     * @param amount số tiền muốn gửi
     * @throws InvalidFundingAmountException nếu số tiền âm
     */
    public void doDepositing(double amount) throws InvalidFundingAmountException {
        if (amount < 0) {
            throw new InvalidFundingAmountException(amount);
        }

        balance += amount;
    }

    public abstract void withdraw(double amount);

    public abstract void deposit(double amount);

    /**
     * Lấy lịch sử giao dịch của tài khoản.
     *
     * @return chuỗi chứa tất cả giao dịch
     */
    public String getTransactionHistory() {
        StringBuilder sb = new StringBuilder();
        sb.append("Lịch sử giao dịch của tài khoản ").append(accountNumber).append(":\n");
        for (Transaction trans : transactionList) {
                sb.append(trans.getTransactionSummary()).append("\n");
        }

        return sb.toString();
    }

    public void addTransaction(Transaction trans) {
        transactionList.add(trans);
    }

    /**
     * So sánh hai tài khoản dựa trên số tài khoản.
     *
     * @param o đối tượng cần so sánh
     * @return true nếu hai tài khoản có cùng số tài khoản
     */
    public boolean equals(Object o) {
        if (o instanceof Account) {
            Account acc = (Account) o;
            return (accountNumber == acc.getAccountNumber());
        }
        return false;
    }

}
