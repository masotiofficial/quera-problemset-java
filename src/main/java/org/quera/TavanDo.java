package org.quera;

import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/616

*/

public class TavanDo {
    public static void main(String[] args) {
        powerTwo();
    }

    private static void powerTwo() {
        System.out.println((int) Math.pow(2, Math.floor(Math.log(Input.getInput().n) / Math.log(2) + 1)));
    }

    private record Input(int n) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static Input getInput() {
            return new Input(SCANNER.nextInt());
        }
    }
}
