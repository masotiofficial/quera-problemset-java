import java.util.Arrays;
import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/171788

*/

public class TheBroCode {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        Arrays.stream(calculateShares(input.friends)).forEach(IO::output);
    }

    private static Share[] calculateShares(Parameters[] friends) {
        return Arrays.stream(friends)
                .map(Share::new)
                .toArray(Share[]::new);
    }

    private static class Share {
        final int pizzas;
        final int maxPieces;

        public Share(Parameters params) {
            double h = (double) params.m / params.t;
            int hFloor = params.m / params.t;

            this.pizzas = (int) Math.ceil(h * params.b / 8.0);

            int totalPieces = this.pizzas * 8;
            int minForOthers = (params.b - 1) * hFloor;
            this.maxPieces = totalPieces - minForOthers;
        }

        @Override
        public String toString() {
            return pizzas + " " + maxPieces;
        }
    }

    private record Parameters(int m, int t, int b) {
    }

    private record IO(Parameters[] friends) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            int t = SCANNER.nextInt();

            Parameters[] friends = new Parameters[t];
            for (int i = 0; i < t; i++) {
                friends[i] = new Parameters(SCANNER.nextInt(), SCANNER.nextInt(), SCANNER.nextInt());
            }

            return new IO(friends);
        }

        static void output(Object output) {
            System.out.println(output);
        }
    }
}