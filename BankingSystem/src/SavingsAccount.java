public class SavingsAccount extends Account {
    public SavingsAccount(long accountNumber, double balance) {
        super(accountNumber, balance);
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 1000 || balance < 5000) {
            return;
        }

        try {
            doWithdrawing(amount);
            Transaction trans = new Transaction(3, amount, balance + amount, balance);
            addTransaction(trans);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deposit(double amount) {
        try {
            doDepositing(amount);
            Transaction trans = new Transaction(2, amount, balance - amount, balance);
            addTransaction(trans);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
