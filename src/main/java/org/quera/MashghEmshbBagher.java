package org.quera;

import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/3429

*/

public class MashghEmshbBagher {
    public static void main(String[] args) {
        isTriangle();
    }

    private static void isTriangle() {
        Input input = Input.getInput();

        System.out.println(triangle(input.x, input.y, input.z) ? "Yes" : "No");
    }

    private static boolean triangle(int x, int y, int z) {
        return (x != 0 && y != 0 && z != 0) && (x + y + z == 180);
    }

    private record Input(int x, int y, int z) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static Input getInput() {
            return new Input(SCANNER.nextInt(), SCANNER.nextInt(), SCANNER.nextInt());
        }
    }
}
