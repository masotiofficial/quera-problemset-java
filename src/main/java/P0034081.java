import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/34081

*/

public class P0034081 {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(countSteps(input.n, input.k, 1, 0));
    }

    private static int countSteps(int n, int k, int currentPosition, int steps) {
        if ((currentPosition == 1) && (steps != 0)) {
            return steps;
        } else {
            int nextPosition = currentPosition + k;
            nextPosition = nextPosition >= n ? nextPosition - n : nextPosition;

            return countSteps(n, k, nextPosition, steps + 1);
        }
    }

    private record IO(int n, int k) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            return new IO(SCANNER.nextInt(), SCANNER.nextInt());
        }

        static void output(Object output) {
            System.out.println(output);
        }
    }
}