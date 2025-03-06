package org.quera;

import java.util.*;
import java.util.stream.IntStream;

/*

  Problem link: https://quera.org/problemset/66861

*/

public class AdadKhob {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        int i = 1;
        int goodNumber = goodNumbers(i);
        while (countDividers(goodNumber) < input.k) {
            goodNumber = goodNumbers(++i);
        }

        IO.output(goodNumber);
    }

    private static int countDividers(int n) {
        int count = 1;

        for (int i = 1; i <= n / 2; i++) {
            if (n % i == 0) {
                count++;
            }
        }

        return count;
    }

    private static int goodNumbers(int n) {
        return n * (n + 1) / 2;
    }

    private record IO(int k) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            return new IO(SCANNER.nextInt());
        }

        static void output(Object output) {
            System.out.println(output);
        }
    }
}