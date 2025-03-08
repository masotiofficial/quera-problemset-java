package org.quera;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

/*

  Problem link: https://quera.org/problemset/33023

*/

public class Zini {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(countValidGrids(input.table));
    }

    private static int countValidGrids(int[][] table) {
        AtomicInteger count = new AtomicInteger();

        IntStream.range(1, table.length - 1)
                .forEach(row -> IntStream.range(1, table[row].length - 1)
                        .forEach(column -> {
                                    int current = table[row][column];
                                    int upper = table[row - 1][column];
                                    int right = table[row][column + 1];
                                    int lower = table[row + 1][column];
                                    int left = table[row][column - 1];

                                    if (((current > right) && (current > left)) && ((current < upper) && (current < lower))) {
                                        count.getAndIncrement();
                                    }

                                    if (((current < right) && (current < left)) && ((current > upper) && (current > lower))) {
                                        count.getAndIncrement();
                                    }
                                }
                        )
                );

        return count.intValue();
    }

    private record IO(int[][] table) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            int n = SCANNER.nextInt();
            int m = SCANNER.nextInt();

            int[][] table = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    table[i][j] = SCANNER.nextInt();
                }
            }

            return new IO(table);
        }

        static void output(Object output) {
            System.out.println(output);
        }
    }
}