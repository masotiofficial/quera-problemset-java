package org.quera;

import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/147193

*/

public class ModaleKhat {
    public static void main(String[] args) {
        answer();
    }

    private static void answer() {
        Input input = Input.getInput();

        System.out.println(result(solveEquationLine(input.a, input.b)));
    }

    private static String result(double value) {
        if (Double.isNaN(value)) {
            return "infinite";
        } else if (value == Double.POSITIVE_INFINITY || value == Double.NEGATIVE_INFINITY) {
            return "invalid";
        } else {
            return "unique";
        }
    }

    private static double solveEquationLine(int a, int b) {
        return (double) -b / a;
    }

    private record Input(int a, int b) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static Input getInput() {
            return new Input(SCANNER.nextInt(), SCANNER.nextInt());
        }
    }
}
