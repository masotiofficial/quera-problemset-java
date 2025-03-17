import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/2637

*/

public class JadeKeshi {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(maxParts(input.n));
    }

    private static int maxParts(int n) {
        int a = (int) (Math.floor(n / 2.0) + 1);
        int b = (int) (Math.ceil(n / 2.0) + 1);

        return a * b;
    }

    private record IO(int n) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            return new IO(SCANNER.nextInt());
        }

        static void output(Object output) {
            System.out.print(output);
        }
    }
}