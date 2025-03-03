package org.quera;

import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/44077

*/

public class KaghazKadoChaharZelee {
    public static void main(String[] args) {
        maximumArea();
    }

    private static void maximumArea() {
        Input input = Input.getInput();

        System.out.println(calculateArea(input.a, input.b, input.c, input.d));
    }

    private static double calculateArea(int a, int b, int c, int d) {
        double p = (double) calculatePerimeter(a, b, c, d) / 2;

        return Math.sqrt((p - a) * (p - b) * (p - c) * (p - d));
    }

    private static int calculatePerimeter(int a, int b, int c, int d) {
        return a + b + c + d;
    }

    private record Input(int a, int b, int c, int d) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static Input getInput() {
            return new Input(SCANNER.nextInt(), SCANNER.nextInt(), SCANNER.nextInt(), SCANNER.nextInt());
        }
    }
}