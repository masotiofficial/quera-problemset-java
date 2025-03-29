import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/11585

*/

public class JameHameyeZirBazeHa {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(sumOfAllSubIntervals(input.n, input.a));
    }

    private static long sumOfAllSubIntervals(int length, long[] set) {
        long result = 0;

        for (int i = 0; i < length; i++) {
            result += set[i] * (i + 1) * (length - i);
        }

        return result;
    }

    private record IO(int n, long[] a) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            int n = SCANNER.nextInt();

            long[] a = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = SCANNER.nextInt();
            }

            return new IO(n, a);
        }

        static void output(Object output) {
            System.out.println(output);
        }
    }
}