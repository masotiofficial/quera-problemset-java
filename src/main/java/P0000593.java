import java.util.Arrays;
import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/593

*/

public class P0000593 {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(findDesiredNumber(input.n));
    }

    private static int findDesiredNumber(int n) {
        int b = Arrays.stream(String.valueOf(n).split(""))
                .mapToInt(Integer::parseInt)
                .sum();

        int prime = 0;
        for (int countNumbers = 1, countPrimes = 0; countPrimes != b; countNumbers++) {
            prime = n + countNumbers;

            if (isPrime(prime)) {
                countPrimes++;
            }
        }

        return prime;
    }

    private static boolean isPrime(int n) {
        if (n == 1) {
            return false;
        }

        if (n == 2) {
            return true;
        }

        if (n == 3) {
            return true;
        }

        if (n % 2 == 0 || n % 3 == 0) {
            return false;
        }

        for (int i = 5; i * i <= n; i += 6) {
            if ((n % i == 0) || (n % (i + 2) == 0)) {
                return false;
            }
        }

        return true;
    }

    private record IO(int n) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            return new IO(SCANNER.nextInt());
        }

        static void output(Object output) {
            System.out.println(output);
        }
    }
}