package org.quera;

import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/83360

*/

public class NazaryeRisman {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(search(input.keySearch, input.searchString) ? 1 : 0);
    }

    private static boolean search(String keySearch, String searchString) {
        return searchString.contains(keySearch);
    }

    private record IO(String keySearch, String searchString) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            return new IO(SCANNER.nextLine(), SCANNER.nextLine());
        }

        static void output(Object output) {
            System.out.println(output);
        }
    }
}