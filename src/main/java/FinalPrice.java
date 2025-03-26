import java.util.Arrays;
import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/275494

*/

public class FinalPrice {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(calculateFinalPrice(input.prices));
    }

    private static int calculateFinalPrice(int[] prices) {
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