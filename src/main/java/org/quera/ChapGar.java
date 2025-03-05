package org.quera;

import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/64434

*/

public class ChapGar {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(checkeredRectangle(input.n, input.m));
    }

    private static StringBuilder checkeredRectangle(int n, int m) {
        StringBuilder checkered = new StringBuilder();

        String xFull = fullRectangle(m, "X");
        String dotFull = fullRectangle(m, ".");

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 3; k++) {
                    if (((i % 2 == 0) && (k % 2 == 0)) || ((i % 2 != 0) && (k % 2 != 0))) {
                        checkered.append(xFull);
                    } else {
                        checkered.append(dotFull);
                    }
                }

                checkered.append("\n");
            }
        }

        return checkered;
    }

    private static String fullRectangle(int m, String filler) {
        return filler.repeat(m);
    }

    private record IO(int n, int m) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            return new IO(SCANNER.nextInt(), SCANNER.nextInt());
        }

        static void output(Object output) {
            System.out.println(output);
        }
    }
}