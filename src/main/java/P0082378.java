import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/82378

*/

public class P0082378 {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(calculateCost(input.n, input.k));
    }

    private static int calculateCost(int totalConsumption, int extraQuota) {
        final int BASE_QUOTA = 60;
        final int QUOTA_PRICE = 1500;
        final int EXTRA_PRICE = 3000;

        int totalQuota = BASE_QUOTA + extraQuota;
        int extraConsumption = totalConsumption - totalQuota;

        if (extraConsumption > 0) {
            return extraConsumption * EXTRA_PRICE + totalQuota * QUOTA_PRICE;
        } else {
            return totalConsumption * QUOTA_PRICE;
        }
    }

    private record IO(int n, int k) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            return new IO(SCANNER.nextInt(), SCANNER.nextInt());
        }

        static void output(Object output) {
            System.out.println(output);
        }
    }
}