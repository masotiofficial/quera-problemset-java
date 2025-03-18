import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/72877

*/

public class PashmalAgha {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(calculateIncome(input.n, input.k, input.p));
    }

    private static int calculateIncome(int n, double k, int p) {
        return (int) (n * p * k);
    }

    private record IO(int n, double k, int p) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            return new IO(SCANNER.nextInt(), SCANNER.nextDouble(), SCANNER.nextInt());
        }

        static void output(Object output) {
            System.out.println(output);
        }
    }
}