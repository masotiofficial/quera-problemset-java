import java.util.Scanner;
import java.util.stream.IntStream;

/*

  Problem link: https://quera.org/problemset/26651

*/

public class P0026651 {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(sum(input.n, input.a, input.b));
    }

    private static int sum(int n, int[] a, int[] b) {
        return IntStream.range(0, n).map(i -> a[i] * b[i]).sum();
    }

    private record IO(int n, int[] a, int[] b) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            int n = SCANNER.nextInt();

            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = SCANNER.nextInt();
            }

            int[] b = new int[n];
            for (int i = 0; i < n; i++) {
                b[i] = SCANNER.nextInt();
            }

            return new IO(n, a, b);
        }

        static void output(Object output) {
            System.out.println(output);
        }
    }
}