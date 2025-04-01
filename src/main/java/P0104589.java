import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/104589

*/

public class P0104589 {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(maxCoins(input.n()));
    }

    private static int maxCoins(int pancakesCount) {
        int maxCustomers = 1;

        for (int i = 1; i * i <= pancakesCount; i++) {
            if (pancakesCount % i == 0) {
                if (i < pancakesCount) {
                    maxCustomers = Math.max(maxCustomers, i);
                }

                int otherDivisor = pancakesCount / i;

                if (otherDivisor < pancakesCount) {
                    maxCustomers = Math.max(maxCustomers, otherDivisor);
                }
            }
        }

        return maxCustomers;
    }

    private record IO(int n) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            return new IO(SCANNER.nextInt());
        }

        static void output(Object output) {
            System.out.print(output);
        }
    }
}