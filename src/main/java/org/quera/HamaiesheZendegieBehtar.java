package org.quera;

import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/10325

*/

public class HamaiesheZendegieBehtar {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(routing(input.r, input.c));
    }

    private static String routing(int r, int c) {
        String route;

        route = c <= 10 ? "Right" : "Left";

        int a = -r + 11;
        int b = c <= 10 ? c : -c + 21;

        route = route + " " + a + " " + b;

        return route;
    }

    private record IO(int r, int c) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            return new IO(SCANNER.nextInt(), SCANNER.nextInt());
        }

        static void output(Object output) {
            System.out.print(output);
        }
    }
}