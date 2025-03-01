package org.quera;

import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/9774

*/

public class AdadChapKon {
    public static void main(String[] args) {
        repeat();
    }

    private static void repeat() {
        String[] digits = Input.getInput().n.split("");

        for (String digit : digits) {
            System.out.println(digit + ": " + digit.repeat(Integer.parseInt(digit)));
        }
    }

    private record Input(String n) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static Input getInput() {
            return new Input(SCANNER.nextLine());
        }
    }
}
