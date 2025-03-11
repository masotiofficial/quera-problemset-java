package org.quera;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/297

*/

public class TabeNameye {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(String.format("%.3f", exponentialFunction(input.x, input.n)));
    }

    private static BigDecimal exponentialFunction(int x, int n) {
        BigDecimal result = BigDecimal.ZERO;

        BigDecimal xBigDecimal = new BigDecimal(x);
        BigDecimal factorial = BigDecimal.ONE;
        for (int i = 0; i < n; i++) {
            factorial = factorial.multiply(i == 0 ? BigDecimal.ONE : BigDecimal.valueOf(i));

            result = result.add(xBigDecimal.pow(i).divide(factorial, 10, RoundingMode.HALF_UP));
        }

        return result;
    }

    private record IO(int x, int n) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            return new IO(SCANNER.nextInt(), SCANNER.nextInt());
        }

        static void output(Object output) {
            System.out.println(output);
        }
    }
}