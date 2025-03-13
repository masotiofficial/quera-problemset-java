package org.quera;

import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/28948

*/

public class BeType {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(correctedString(input.s));
    }

    private static String correctedString(String uncorrectedString) {
        StringBuilder result = new StringBuilder();

        for (char c : uncorrectedString.toCharArray()) {
            if (c == '=') {
                if (!result.isEmpty()) {
                    result.setLength(result.length() - 1);
                }
            } else {
                result.append(c);
            }
        }

        return result.toString();
    }

    private record IO(String s) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            return new IO(SCANNER.nextLine());
        }

        static void output(Object output) {
            System.out.println(output);
        }
    }
}