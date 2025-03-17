import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/647

*/

public class SigmaGir {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(series(input.n, input.m));
    }

    private static int series(int n, int m) {
        int result = 0;

        for (int i = -10; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                result += (int) (Math.pow(i + j, 3) / Math.pow(j, 2));
            }
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