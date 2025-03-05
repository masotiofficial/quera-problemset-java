package org.quera;

import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/209103

*/

public class JadvaleDekarti {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(cartesianTable(input.n, input.m));
    }

    private static StringBuilder cartesianTable(int n, int m) {
        StringBuilder table = new StringBuilder();

        String length = sides(m + 1, "| ") + "\n";
        String width = sides(m, " _") + "\n";

        for (int i = 0; i < 2 * n + 1; i++) {
            if (i == 2 * n) {
                table.append(width);
            } else {
                if (i % 2 == 0) {
                    table.append(width);
                } else {
                    table.append(length);
                }
            }
        }

        return table;
    }

    private static String sides(int m, String filler) {
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