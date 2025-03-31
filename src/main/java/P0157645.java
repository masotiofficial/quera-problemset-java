import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/157645

*/

public class P0157645 {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(countRabbitsExplicit(input.P, input.L, input.Y));
    }

    private static int countRabbitsExplicit(int P, int L, int Y) {
        int coefficient = (int) Math.pow(2, Y);

        return (coefficient * P) - ((coefficient - 1) * L);
    }

    private static int countRabbitsRecursive(int P, int L, int Y) {
        if (Y == 0) {
            return P;
        } else {
            return 2 * countRabbitsRecursive(P, L, Y - 1) - L;
        }
    }

    private record IO(int P, int L, int Y) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            return new IO(SCANNER.nextInt(), SCANNER.nextInt(), SCANNER.nextInt());
        }

        static void output(Object output) {
            System.out.println(output);
        }
    }
}