import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/283

*/

public class MorabaeToKhali {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(createHollowSquare(input.a, input.b));
    }

    private static String createHollowSquare(int outerSize, int innerSize) {
        if (outerSize <= innerSize) {
            return "Wrong order!";
        } else if (((outerSize - innerSize) % 2) != 0) {
            return "Wrong difference!";
        } else {
            return buildSquare(outerSize, innerSize);
        }
    }

    private static String buildSquare(int outerSize, int innerSize) {
        StringBuilder square = new StringBuilder();

        int margin = (outerSize - innerSize) / 2;

        String fullRow = "* ".repeat(outerSize);
        String hollowRow = "* ".repeat(margin) + "  ".repeat(innerSize) + "* ".repeat(margin);

        for (int i = 0; i < outerSize; i++) {
            square.append((i < margin) || (i >= outerSize - margin) ? fullRow : hollowRow)
                    .append("\n");
        }

        return square.toString();
    }

    private record IO(int a, int b) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            return new IO(SCANNER.nextInt(), SCANNER.nextInt());
        }

        static void output(Object output) {
            System.out.println(output);
            ;
        }
    }
}