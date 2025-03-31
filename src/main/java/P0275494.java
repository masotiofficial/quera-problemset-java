import java.util.Arrays;
import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/275494

*/

public class P0275494 {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(calculateP0275494(input.prices));
    }

    private static int calculateP0275494(int[] prices) {
        return Arrays.stream(prices).sum();
    }

    private record IO(int[] prices) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            int n = SCANNER.nextInt();

            int[] prices = new int[n];
            for (int i = 0; i < n; i++) {
                prices[i] = SCANNER.nextInt();
            }

            return new IO(prices);
        }

        static void output(Object output) {
            System.out.println(output);
        }
    }
}