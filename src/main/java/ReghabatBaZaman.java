import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/236459

*/

public class ReghabatBaZaman {
    public static void main(String[] args) {
        minimumTime();
    }

    private static void minimumTime() {
        Input input = Input.getInput();

        System.out.println(calculateMinimumTime(input.k, input.n, input.buildings));
    }

    private static int calculateMinimumTime(int k, int n, int[] buildings) {
        int totalTime = 0;

        int heightDifference;
        for (int i = 0; i < buildings.length - 1; i++) {
            heightDifference = Math.abs(buildings[i] - buildings[i + 1]);

            totalTime += heightDifference % k == 0 ? heightDifference / k : heightDifference / k + 1;
        }

        totalTime += n;

        return totalTime;
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