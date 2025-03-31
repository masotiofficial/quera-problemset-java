import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/31025

*/

public class P0031025 {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(divide(input.n, input.k));
    }

    private static int divide(int n, int k) {
        return Math.floorDiv(n, (int) Math.pow(2, k));
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