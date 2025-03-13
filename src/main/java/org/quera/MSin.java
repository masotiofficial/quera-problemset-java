package org.quera;

import java.util.Arrays;
import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/28947

*/

public class MSin {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        Arrays.stream(calculateScore(input.m)).forEach(IO::output);
    }

    private static String[] calculateScore(int m) {
        return Arrays.stream(new String[]{"sib", "samano", "seke", "serke", "senjed", "sabze", "somagh"})
                .limit(m)
                .toArray(String[]::new);
    }

    private record IO(int m) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            return new IO(SCANNER.nextInt());
        }

        static void output(Object output) {
            System.out.println(output);
        }
    }
}