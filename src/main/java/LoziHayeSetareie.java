import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/9773

*/

public class LoziHayeSetareie {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(rhombus(input.n));
    }

    private static StringBuilder rhombus(int n) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < n; i++) {
            String stars = "*".repeat(-Math.abs(2 * i - (n - 1)) + n);

            result.append(" ".repeat(Math.abs((2 * i - (n - 1))) / 2))
                    .append(stars)
                    .append(" ".repeat(Math.abs((2 * i - (n - 1)))))
                    .append(stars)
                    .append('\n');
        }

        return result;
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