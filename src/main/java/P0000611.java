import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

/*

  Problem link: https://quera.org/problemset/611

*/

public class P0000611 {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(Arrays.stream(buildMagicSquare(input.n(), input.m()))
                .map(row -> Arrays.stream(row)
                        .mapToObj(String::valueOf)
                        .collect(Collectors.joining(" ")))
                .collect(Collectors.joining("\n"))
        );
    }

    private static int[][] buildMagicSquare(int n, int m) {
        int[][] result = new int[n][n];

        int i = 0;
        int j = ((n + 1) / 2) - 1;
        result[i][j] = m;

        for (int count = 1; count < n * n; count++) {
            int previousI = i;
            int previousJ = j;

            i = (i - 1 + n) % n;
            j = (j + 1) % n;

            if (result[i][j] != 0) {
                i = (previousI + 1) % n;
                j = previousJ;
            }

            result[i][j] = ++m;
        }

        return result;
    }

    private record IO(int n, int m) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            return new IO(SCANNER.nextInt(), SCANNER.nextInt());
        }

        static void output(Object output) {
            System.out.println(output);
        }
    }
}