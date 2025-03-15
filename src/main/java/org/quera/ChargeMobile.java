package org.quera;

import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/17244

*/

public class ChargeMobile {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(charge(input.k));
    }

    private static int charge(int k) {
        return k * (k + 1) / 2;
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