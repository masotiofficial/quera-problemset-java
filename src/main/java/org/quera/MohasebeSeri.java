package org.quera;

import java.math.BigInteger;
import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/638

*/

public class MohasebeSeri {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(series(input.n));
    }

    private static BigInteger series(int n) {
        BigInteger result = BigInteger.ZERO;

        for (int i = 1; i <= n; i++) {
            BigInteger multiplication = BigInteger.ONE;

            for (int j = 1; j <= i; j++) {
                multiplication = multiplication.multiply(combination(i, j));
            }

            result = result.add(multiplication);
        }

        return result;
    }

    private static BigInteger combination(int n, int r) {
        BigInteger numerator = factorial(n - r + 1, n);
        BigInteger denominator = factorial(1, r);

        return numerator.divide(denominator);
    }

    private static BigInteger factorial(int start, int end) {
        BigInteger factorial = BigInteger.ONE;

        for (int i = start; i <= end; i++) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }

        return factorial;
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