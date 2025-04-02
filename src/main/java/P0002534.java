import java.util.Arrays;
import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/2534

*/

public class P0002534 {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(minTimeForEqualizeHeight(input.n(), input.heights()));
    }

    private static int minTimeForEqualizeHeight(int columns, int[] coins) {
        int result = 0;

        int sum = Arrays.stream(coins).sum();
        int height = sum / columns;

        for (int coin : coins) {
            if (coin < height) {
                result += height - coin;
            }
        }

        return result;
    }

    private record IO(int n, int[] heights) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            int n = SCANNER.nextInt();

            int[] heights = new int[n];
            for (int i = 0; i < n; i++) {
                heights[i] = SCANNER.nextInt();
            }

            return new IO(n, heights);
        }

        static void output(Object output) {
            System.out.println(output);
        }
    }
}