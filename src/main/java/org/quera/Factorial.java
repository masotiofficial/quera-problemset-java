package org.quera;

import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/589

*/

public class Factorial {
    public static void main(String[] args) {
        factorial();
    }

    private static void factorial() {
        System.out.println(computeFactorial(Input.getInput().n()));
    }

    private static int computeFactorial(int n) {
        int factorial = 1;

        for (int i = 2; i <= n; i++) {
            factorial *= i;
        }

        return factorial;
    }

    private record Input(int n) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static Input getInput() {
            return new Input(SCANNER.nextInt());
        }
    }
}

