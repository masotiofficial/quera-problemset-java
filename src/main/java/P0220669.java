import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/220669

*/

public class P0220669 {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(generateDeltaLogo(input.n));
    }

    private static StringBuilder generateDeltaLogo(int size) {
        StringBuilder result = new StringBuilder();

        result.append(".".repeat(size - 1));
        result.append("D");
        result.append(".".repeat(size - 1));
        result.append('\n');
        for (int i = 1; i < size - 1; i++) {
            int outerDots = size - 1 - i;
            int innerDots = 2 * i - 1;

            result.append(".".repeat(outerDots))
                    .append("D")
                    .append(".".repeat(innerDots))
                    .append("D")
                    .append(".".repeat(outerDots))
                    .append("\n");
        }
        result.append("D");
        result.append(".D".repeat(size - 1));

        return result;
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