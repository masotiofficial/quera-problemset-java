import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/618

*/

public class ChapeLozi {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(rhombus(input.n));
    }

    private static StringBuilder rhombus(int n) {
        StringBuilder rhombus = new StringBuilder();

        for (int i = 0; i < 2 * n + 1; i++) {
            rhombus.append(" ".repeat(Math.abs(i - n)))
                    .append("*".repeat(-Math.abs(2 * (i - n)) + 2 * n + 1))
                    .append("\n");
        }

        return rhombus;
    }

    private record IO(int n) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            return new IO(SCANNER.nextInt());
        }

        static void output(Object output) {
            System.out.println(output);
        }
    }
}