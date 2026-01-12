public class Transaction {
    public static final int TYPE_DEPOSIT_CHECKING = 0;
    public static final int TYPE_WITHDRAW_CHECKING = 1;
    public static final int TYPE_DEPOSIT_SAVINGS = 2;
    public static final int TYPE_WITHDRAW_SAVINGS = 3;
    private int type;
    private double amount;
    private double initialBalance;
    private double finalBalance;

    /**
     * Constructor tạo giao dịch mới.
     *
     * @param type           loại giao dịch (deposit/withdraw cho checking hoặc savings)
     * @param amount         số tiền giao dịch
     * @param initialBalance số dư ban đầu
     * @param finalBalance   số dư sau khi giao dịch
     */
    public Transaction(int type, double amount, double initialBalance, double finalBalance) {
        this.type = type;
        this.amount = amount;
        this.initialBalance = initialBalance;
        this.finalBalance = finalBalance;
    }

    private String getTransactionTypeString(int type) {
        String res = "";
        if (type == 0) {
            res = "Nạp tiền vãng lai";
        }

        if (type == 1) {
            res = "Rút tiền vãng lai";
        }

        if (type == 2) {
            res = "Nạp tiền tiết kiệm";
        }

        if (type == 3) {
            res = "Rút tiền tiết kiệm";
        }

        return res;
    }

    /**
     * Lấy tóm tắt giao dịch dưới dạng chuỗi.
     *
     * @return chuỗi tóm tắt giao dịch
     */
    public String getTransactionSummary() {
        return String.format("- Kiểu giao dịch: %s. Số dư "
                        + "ban đầu: $%.2f. Số tiền: $%.2f. Số dư cuối: $%.2f.",
                getTransactionTypeString(type), initialBalance, amount, finalBalance);
    }
}
