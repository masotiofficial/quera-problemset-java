package org.quera;

import java.math.BigInteger;
import java.util.*;

/*

  Problem link: https://quera.org/problemset/276

*/

public class TolVaMajmoeArgham {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        if ((input.m == 1) && (input.s == 0)) {
            IO.output("0");
        } else if ((input.m <= 0) || (input.s <= 0) || (input.s > 9 * input.m)) {
            IO.output("-1 -1");
        } else {
            IO.output(min(input.m, input.s) + " " + max(input.m, input.s));
        }
    }

    private static BigInteger min(int m, int s) {
        m = m - 1;

        int third_1 = (int) Math.floor((1.0 / 9.0) * s);
        third_1 = s % 9 == 0 ? third_1 - 1 : third_1;
        BigInteger third_2 = BigInteger.TEN.pow(third_1).subtract(BigInteger.ONE);

        int second_1 = (s - 1) % 9;
        second_1 = (s - 1) % 9 == 0 ? 0 : second_1;
        BigInteger second_2 = BigInteger.valueOf(second_1).multiply(BigInteger.TEN.pow(third_1));

        BigInteger first_1 = BigInteger.TEN.pow(m);

        return first_1.add(second_2).add(third_2);
    }

    private static BigInteger max(int m, int s) {
        m = m - 1;

        int first_1 = (int) Math.floor((1.0 / 9.0) * s);
        first_1 = s % 9 == 0 ? first_1 - 1 : first_1;
        BigInteger first_2 = BigInteger.TEN.pow(first_1).subtract(BigInteger.ONE).multiply(BigInteger.TEN.pow((m + 1) - first_1));

        int second_1 = (s - 1) % 9;
        BigInteger second_2 = BigInteger.valueOf(second_1 + 1).multiply(BigInteger.TEN.pow(m - first_1));

        return first_2.add(second_2);
    }

    private record IO(int m, int s) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            return new IO(SCANNER.nextInt(), SCANNER.nextInt());
        }

        static void output(Object output) {
            System.out.println(output);
        }
    }
}