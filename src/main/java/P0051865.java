import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/51865

*/

public class P0051865 {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(calculateScore(input.x, input.n));
    }

    private static int calculateScore(int x, int n) {
        return switch (n) {
            case 0 -> 20;
            case 7 -> x;
            default -> Math.max(0, x - n);
        };
    }

    private record IO(int x, int n) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            return new IO(SCANNER.nextInt(), SCANNER.nextInt());
        }

        static void output(Object output) {
            System.out.println(output);
        }
    }
}