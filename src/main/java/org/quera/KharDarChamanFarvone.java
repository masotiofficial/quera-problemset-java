package org.quera;

import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/4065

*/

public class KharDarChamanFarvone {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(soundGenerationTime(input.a, input.b, input.l));
    }

    private static int soundGenerationTime(int a, int b, int l) {
        return l % 2 == 0 ? (l / 2) * a + (l / 2) * b : (l - l / 2) * a + (l / 2) * b;
    }

    private record IO(int a, int b, int l) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            return new IO(SCANNER.nextInt(), SCANNER.nextInt(), SCANNER.nextInt());
        }

        static void output(Object output) {
            System.out.print(output);
        }
    }
}