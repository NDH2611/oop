public class DiscreteDistribution {
    public static void main(String[] args) {
        int n = args.length;
        int[] arr = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++)
        {
            arr[i] = Integer.parseInt(args[i]);
            sum += arr[i];
        }
        int rand = (int) (sum * Math.random());
        int val = 0;
        int index = -1;
        for (int i = 0; i < n && val <= rand; i++) {
            val += arr[i];
            index = i;
        }
        System.out.println(index);

    }
}
