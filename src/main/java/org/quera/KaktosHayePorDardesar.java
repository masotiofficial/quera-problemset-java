package org.quera;

import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/52542

*/

public class KaktosHayePorDardesar {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(distributeCacti(input.n, input.people));
    }

    private static String distributeCacti(int n, int[] people) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < n; i++) {
            result.append("*".repeat(people[i] <= 3 ? people[i] : 1));
            result.append('\n');
        }

        return result.toString();
    }

    private record IO(int n, int[] people) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            int n = SCANNER.nextInt();

            int[] people = new int[n];
            for (int i = 0; i < n; i++) {
                people[i] = SCANNER.nextInt();
            }

            return new IO(n, people);
        }

        static void output(Object output) {
            System.out.print(output);
        }
    }
}