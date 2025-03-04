package org.quera;

import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/235088

*/

public class BarnameRizieProject {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(minimumDays(input.n, input.l, input.r));
    }

    private static int minimumDays(int n, int l, int r) {
        int minimumDays = (n + r - 1) / r;
        int maximumDays = (n + l - 1) / l;

        int min;
        int max;
        for (int days = minimumDays; days <= maximumDays; days++) {
            min = days * l;
            max = days * r;

            if ((min <= n) && (n <= max)) {
                return days;
            }
        }

        return -1;
    }

    private record IO(int n, int l, int r) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            return new IO(Integer.parseInt(SCANNER.nextLine()), SCANNER.nextInt(), SCANNER.nextInt());
        }

        static void output(Object output) {
            System.out.println(output);
        }
    }
}