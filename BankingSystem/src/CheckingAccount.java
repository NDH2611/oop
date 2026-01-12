public class CheckingAccount extends Account {
    public CheckingAccount(long accountNumber, double balance) {
        super(accountNumber, balance);
    }

    @Override
    public void withdraw(double amount) {
        try {
            doWithdrawing(amount);
            Transaction trans = new Transaction(1, amount, balance + amount, balance);
            addTransaction(trans);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Thực hiện gửi tiền vào tài khoản vãng lai.
     * Nếu xảy ra lỗi (số tiền âm) sẽ in thông báo lỗi.
     *
     * @param amount số tiền muốn gửi
     */
    public void deposit(double amount) {
        try {
            doDepositing(amount);
            Transaction trans = new Transaction(0, amount, balance - amount, balance);
            addTransaction(trans);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
