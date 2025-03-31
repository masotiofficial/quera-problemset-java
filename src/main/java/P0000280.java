import java.util.Arrays;
import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/280

*/

public class P0000280 {
    public static void main(String[] args) {
        numbersPythagorean();
    }

    private static void numbersPythagorean() {
        Input input = Input.getInput();

        System.out.println(isPythagoreanTriple(input.a(), input.b(), input.c()) ? "YES" : "NO");
    }

    private static boolean isPythagoreanTriple(int a, int b, int c) {
        return Math.pow(c, 2) == Math.pow(a, 2) + Math.pow(b, 2);
    }

    private record Input(int a, int b, int c) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static Input getInput() {
            int[] numbers = new int[]{SCANNER.nextInt(), SCANNER.nextInt(), SCANNER.nextInt()};

            Arrays.sort(numbers);

            return new Input(numbers[0], numbers[1], numbers[2]);
        }
    }
}