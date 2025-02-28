package org.quera;

import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/218361

*/

public class RoBeRoeDareMetro {
    public static void main(String[] args) {
        peopleFaceToFaceFind();
    }

    private static void peopleFaceToFaceFind() {
        System.out.println(contPeopleFaceToFace(Input.getInput()));
    }

    private static int contPeopleFaceToFace(Input input) {
        int result = 0;

        for (int i = 0; i < input.rightHandSeats().length(); i++) {
            if ((input.rightHandSeats().charAt(i) == '1') && (input.leftHandSeats().charAt(i) == '1')) {
                result++;
            }
        }

        return result;
    }

    private record Input(String rightHandSeats, String leftHandSeats) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static Input getInput() {
            return new Input(SCANNER.nextLine(), SCANNER.nextLine());
        }
    }
}