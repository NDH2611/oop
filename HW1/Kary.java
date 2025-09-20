public class Kary {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);
        String digits = "0123456789ABCDEF";
        String val = "";

        while (n > 0) {
            int x = n % k;
            val = digits.charAt(x) + val;
            n /= k;
        }

        System.out.println(val);
    }
}
