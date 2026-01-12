
public class Main {
    public static void main(String[] args) {
        Account account = new Account();
        account.addTransaction(2000, Transaction.DEPOSIT);
        account.addTransaction(1000, Transaction.WITHDRAW);
        account.printTransaction();
    }
}
