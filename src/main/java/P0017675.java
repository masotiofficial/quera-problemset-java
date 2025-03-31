import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/17675

*/

public class P0017675 {
    public static void main(String[] args) {
        buildSString();
    }

    private static void buildSString() {
        Input input = Input.getInput();

        for (int i = 1; i <= input.n; i++) {
            System.out.print(isFibonacci(i) ? '+' : '-');
        }
    }

    private static boolean isFibonacci(int n) {
        return isPerfectSquare(5 * n * n + 4) || isPerfectSquare(5 * n * n - 4);
    }

    private static boolean isPerfectSquare(int n) {
        int sqrt = (int) Math.sqrt(n);

        return sqrt * sqrt == n;
    }

    private record Input(int n) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static Input getInput() {
            return new Input(SCANNER.nextInt());
        }
    }
}