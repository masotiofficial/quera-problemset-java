package org.quera;

import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/271649

*/

public class MashghMahtab {
    public static void main(String[] args) {
        writeHomework();
    }

    private static void writeHomework() {
        Input input = Input.getInput();

        System.out.println(calculateSumOfOddNumbers(input.n / 2));
    }

    private static int calculateSumOfOddNumbers(int n) {
        return n * n;
    }

    private record Input(int n) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static Input getInput() {
            return new Input(SCANNER.nextInt());
        }
    }
}