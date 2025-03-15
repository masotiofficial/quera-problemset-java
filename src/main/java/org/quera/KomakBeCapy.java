package org.quera;

import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/8838

*/

public class KomakBeCapy {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(copy(input.n, input.s));
    }

    private static String copy(int n, String s) {
        return "copy of ".repeat(n).concat(s);
    }

    private record IO(int n, String s) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            return new IO(SCANNER.nextInt(), SCANNER.next());
        }

        static void output(Object output) {
            System.out.println(output);
        }
    }
}