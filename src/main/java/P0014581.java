import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/14581

*/

public class P0014581 {
    public static void main(String[] args) {
        soundPower();
    }

    private static void soundPower() {
        System.out.println(calculateAverageSoundPower(Input.getInput().n));
    }

    private static double calculateAverageSoundPower(long n) {
        if (n % 2 == 0) {
            return  (double) ((2 * calculateSum(n / 2 - 1)) + (n / 2)) / (n + 1);
        } else {
            return (double) (2 * calculateSum(Math.floorDiv(n, 2))) / (n + 1);
        }
    }

    private static long calculateSum(long n) {
        return (n * (n + 1)) / 2;
    }

    private record Input(int n) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static Input getInput() {
            return new Input(SCANNER.nextInt());
        }
    }
}