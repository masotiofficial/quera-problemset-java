import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/3540

*/

public class P0003540 {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(solveWalnutEquation(input.n, input.x, input.y));
    }

    private static WalnutEquation solveWalnutEquation(int target, int x, int y) {
        int maxX = target / x;

        for (int i = maxX; i >= 0; i--) {
            int a = i;
            int b = (target - a * x) / y;

            if (a * x + b * y == target) {
                return new WalnutEquation(a, b);
            }
        }

        return new WalnutEquation(-1, -1);
    }

    private record WalnutEquation(int xCoefficient, int yCoefficient) {
        @Override
        public String toString() {
            if ((xCoefficient == -1) && (yCoefficient == -1)) {
                return "-1";
            } else {
                return xCoefficient + " " + yCoefficient;

            }
        }
    }

    private record IO(int n, int x, int y) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            return new IO(SCANNER.nextInt(), SCANNER.nextInt(), SCANNER.nextInt());
        }

        static void output(Object output) {
            System.out.print(output);
        }
    }
}