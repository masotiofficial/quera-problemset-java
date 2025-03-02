package org.quera;

import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/236459

*/

public class ReghabatBaZaman {
    public static void main(String[] args) {
        calculateMinimumTime();
    }

    private static void calculateMinimumTime() {
        Input input = Input.getInput();

        System.out.println(calculateTotalDistance(input.k, input.n, input.buildings));
    }

    private static int calculateTotalDistance(int k, int n, int[] buildings) {
        int totalDistance = 0;

        int heightDifference;
        for (int i = 0; i < buildings.length - 1; i++) {
            heightDifference = Math.abs(buildings[i] - buildings[i + 1]);

            totalDistance += heightDifference % k == 0 ? heightDifference / k : heightDifference / k + 1;
        }

        totalDistance += n;

        return totalDistance;
    }

    private record Input(int k, int n, int[] buildings) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static Input getInput() {
            int k = SCANNER.nextInt();
            int n = SCANNER.nextInt();

            int[] buildings = new int[n + 2];
            buildings[0] = 0;
            for (int i = 1; i < n + 1; i++) {
                buildings[i] = SCANNER.nextInt();
            }
            buildings[n + 1] = 0;

            return new Input(k, n, buildings);
        }
    }
}