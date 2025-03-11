package org.quera;

import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/308

*/

public class JenaseGhalb {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(isPalindrome(input.string) ? "YES" : "NO");
    }

    private static boolean isPalindrome(String string) {
        string = formatted(string);

        int length = string.length();
        int halfLength = length / 2;

        String left = string.substring(0, halfLength);

        String right = string.substring(length % 2 == 0 ? halfLength : halfLength + 1, length);
        right = new StringBuilder(right).reverse().toString();

        return left.equals(right);
    }

    private static String formatted(String string) {
        return string.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
    }

    private record IO(String string) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            return new IO(SCANNER.nextLine());
        }

        static void output(Object output) {
            System.out.println(output);
        }
    }
}