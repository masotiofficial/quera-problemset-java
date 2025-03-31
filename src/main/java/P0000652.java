import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/652

*/

public class P0000652 {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        narcissisticNumbers(input.n, input.a).forEach(IO::output);
    }

    private static List<Integer> narcissisticNumbers(int n, int[] a) {
        int endInterval = endInterval(n, a);

        List<Integer> result = new ArrayList<>();
        for (int i = 100; i <= endInterval; i++) {
            if (isNarcissisticNumber(i)) {
                result.add(i);
            }
        }

        return result;
    }

    private static boolean isNarcissisticNumber(int n) {
        String[] digits = String.valueOf(n).split("");

        int result = Arrays.stream(digits)
                .mapToInt(Integer::parseInt)
                .map(digit -> (int) Math.pow(digit, digits.length))
                .sum();

        return result == n;
    }

    private static int endInterval(int n, int[] a) {
        int result = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                result += a[i] * a[j];
            }
        }

        return 2 * result;
    }

    private record IO(int n, int[] a) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            int n = SCANNER.nextInt();

            int[] a = new int[n];
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