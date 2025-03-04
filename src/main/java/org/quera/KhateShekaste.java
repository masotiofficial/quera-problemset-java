package org.quera;

import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/64435

*/

public class KhateShekaste {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO.input();
    }

    private static double calculateArea(String[][] table) {
        double area = 0;

        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                if (table[i][j].equals("_")) {
                    area += table.length - i - 1;
                } else if (table[i][j].equals("/") || table[i][j].equals("\\")) {
                    area += 0.5 + table.length - i - 1;
                }
            }
        }

        return area;
    }

    private record IO() {
        private static final Scanner SCANNER = new Scanner(System.in);

        static void input() {
            int t = SCANNER.nextInt();

            int n;
            int m;
            String[][] table = new String[0][];
            for (int i = 0; i < t; i++) {
                n = SCANNER.nextInt();
                m = SCANNER.nextInt();
                SCANNER.nextLine();

                table = new String[n][m];
                for (int j = 0; j < n; j++) {
                    table[j] = SCANNER.nextLine().split("");
                }

                output(String.format("%.3f", calculateArea(table)));
            }
        }

        static void output(Object output) {
            System.out.println(output);
        }
    }
}