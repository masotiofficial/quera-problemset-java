package org.quera;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

/*

  Problem link: https://quera.org/problemset/52545

*/

public class Mohasebe {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(determineWinner(input.skillScores));
    }

    private static int determineWinner(int[][] skillScores) {
        AtomicInteger max = new AtomicInteger(0);
        AtomicInteger index = new AtomicInteger();

        IntStream.range(0, skillScores.length)
                .forEach(row -> IntStream.range(0, skillScores[row].length)
                        .forEach(column -> {
                                    if (skillScores[row][column] > max.get()) {
                                        max.set(skillScores[row][column]);

                                        index.set(row);
                                    }
                                }
                        )
                );

        return index.get() + 1;
    }

    private record IO(int[][] skillScores) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            int[][] skillScores = new int[4][3];

            for (int i = 0; i < skillScores.length; i++) {
                for (int j = 0; j < skillScores[i].length; j++) {
                    skillScores[i][j] = SCANNER.nextInt();
                }
            }

            return new IO(skillScores);
        }

        static void output(Object output) {
            System.out.println(output);
        }
    }
}