package org.quera;

import java.util.Scanner;
import java.util.stream.IntStream;

/*

  Problem link: https://quera.org/problemset/80651

*/

public class TimKeshi {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(maxNumberTeams(input.developers));
    }

    private static int maxNumberTeams(int[] developers) {
        return IntStream.range(0, developers.length / 2)
                .map(i -> Math.min(developers[2 * i], developers[2 * i + 1]))
                .sum();
    }

    private record IO(int[] developers) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            int[] developers = new int[6];

            for (int i = 0; i < 6; i++) {
                developers[i] = SCANNER.nextInt();
            }

            return new IO(developers);
        }

        static void output(Object output) {
            System.out.print(output);
        }
    }
}