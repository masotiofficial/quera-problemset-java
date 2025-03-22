import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/2705

*/

public class BadKhahPoyan {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(findNearestMultiple(input.p, input.d));
    }

    private static int findNearestMultiple(int p, int d) {
        int result;

        for (int i = 1; ; i++) {
            if (i * d % p <= p / 2) {
                result = i * d;

                break;
            }
        }

        return result;
    }

    private record IO(int p, int d) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            return new IO(SCANNER.nextInt(), SCANNER.nextInt());
        }

        static void output(Object output) {
            System.out.print(output);
        }
    }
}