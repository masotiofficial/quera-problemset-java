package org.quera;

import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/2596

*/

public class HadseAdad {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(guessNumber(input.dividers));
    }

    private static int guessNumber(int[] dividers) {
        int divider = lcm(dividers);

        int possibleNumbers = 0;
        int index = 1;
        while (index * divider <= 1000) {
            possibleNumbers++;

            index++;
        }

        return possibleNumbers;
    }

    private static int lcm(int[] numbers) {
        int lcm = 1;

        for (int number : numbers) {
            lcm = lcm(lcm, number);
        }

        return lcm;
    }

    private static int lcm(int a, int b) {
        return a * (b / gcd(a, b));
    }

    private static int gcd(int a, int b) {
        int temp;

        while (b != 0) {
            temp = b;

            b = a % b;

            a = temp;
        }

        return a;
    }

    private record IO(int[] dividers) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            int q = SCANNER.nextInt();

            int[] dividers = new int[q];
            for (int i = 0; i < q; i++) {
                dividers[i] = SCANNER.nextInt();
            }

            return new IO(dividers);
        }

        static void output(Object output) {
            System.out.println(output);
            ;
        }
    }
}