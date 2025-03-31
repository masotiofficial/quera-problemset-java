import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/293

*/

public class P0000293 {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        primeNumbers(input.a, input.b).forEach(IO::output);
    }

    private static List<Integer> primeNumbers(int a, int b) {
        List<Integer> primes = new ArrayList<>();

        for (int i = a; i <= b; i++) {
            if (isPrime(i)) {
                primes.add(i);
            }
        }

        return primes;
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
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }

        return true;
    }

    private record IO(int a, int b) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            return new IO(SCANNER.nextInt(), SCANNER.nextInt());
        }

        static void output(Object output) {
            System.out.println(output);
        }
    }
}