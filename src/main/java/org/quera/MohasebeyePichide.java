package org.quera;

import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/279

*/

public class MohasebeyePichide {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(series(input.a, input.x, input.n));
    }

    private static int series(int a, int x, int n) {
        int result = 0;

        for (int k = 0; k <= n; k++) {
            result += (int) (combination(n, k) * Math.pow(x, k) * Math.pow(a, n - k));
        }

        return result;
    }

    private static int combination(int n, int r) {
        int numerator = factorial(n - r + 1, n);
        int denominator = factorial(1, r);

        return numerator / denominator;
    }

    private static int factorial(int start, int end) {
        int factorial = 1;

        for (int i = start; i <= end; i++) {
            factorial *= i;
        }

        return factorial;
    }

    private record IO(int a, int x, int n) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            return new IO(SCANNER.nextInt(), SCANNER.nextInt(), SCANNER.nextInt());
        }

        static void output(Object output) {
            System.out.println(output);
        }
    }
}