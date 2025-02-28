package org.quera;

import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/123798

*/

public class KhoshAmad {
    public static void main(String[] args) {
        announceCompetitionStart(Input.getInput().n);
    }

    private static void announceCompetitionStart(int n) {
        System.out.println("Hello CodeCup " + n + "!");
    }

    private record Input(int n) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static Input getInput() {
            return new Input(SCANNER.nextInt());
        }
    }
}
