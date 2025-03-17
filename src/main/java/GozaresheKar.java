import java.util.Arrays;
import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/49535

*/

public class GozaresheKar {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(maxParts(input.n, input.k, input.capacities) ? "YES" : "NO");
    }

    private static boolean maxParts(int n, int k, int[] capacities) {
        int totalCapacity = Arrays.stream(capacities).sum();

        return totalCapacity >= k;
    }

    private record IO(int n, int k, int[] capacities) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            int n = SCANNER.nextInt();
            int k = SCANNER.nextInt();

            int[] capacities = new int[n];
            for (int i = 0; i < n; i++) {
                capacities[i] = SCANNER.nextInt();
            }

            return new IO(n, k, capacities);
        }

        static void output(Object output) {
            System.out.print(output);
        }
    }
}