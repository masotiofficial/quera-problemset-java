import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/304

*/

public class TabeTavanDar {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(String.format("%.3f", power(input.base, input.exp)));
    }

    private static double power(double base, int exp) {
        if (exp == 0) {
            return 1;
        } else {
            return base * power(base, exp - 1);
        }
    }

    private record IO(double base, int exp) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            return new IO(SCANNER.nextDouble(), SCANNER.nextInt());
        }

        static void output(Object output) {
            System.out.println(output);
        }
    }
}