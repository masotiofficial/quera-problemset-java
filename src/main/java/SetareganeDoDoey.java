import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/265396

*/

public class SetareganeDoDoey {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(generatePattern(input.n, input.string));
    }

    private static StringBuilder generatePattern(int length, String binaryString) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < length; j++) {
                result.append(binaryString.charAt(j) == '0' ? Zero.get(i + 1).pattern : One.get(i + 1).pattern);
            }

            result.append('\n');
        }

        return result;
    }

    private enum Zero {
        ONE(0, "***"),
        TWO(1, "*.*"),
        THREE(2, "***");

        final int lineNumber;
        final String pattern;

        Zero(int lineNumber, String pattern) {
            this.lineNumber = lineNumber;
            this.pattern = pattern;
        }

        static Zero get(int lineNumber) {
            return switch (lineNumber) {
                case 1 -> ONE;
                case 2 -> TWO;
                case 3 -> THREE;
                default -> throw new AssertionError();
            };
        }
    }

    private enum One {
        ONE(0, ".*."),
        TWO(1, ".*."),
        THREE(2, ".*.");

        final int lineNumber;
        final String pattern;

        One(int lineNumber, String pattern) {
            this.lineNumber = lineNumber;
            this.pattern = pattern;
        }

        static One get(int lineNumber) {
            return switch (lineNumber) {
                case 1 -> ONE;
                case 2 -> TWO;
                case 3 -> THREE;
                default -> throw new AssertionError();
            };
        }
    }

    private record IO(int n, String string) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            return new IO(Integer.parseInt(SCANNER.nextLine()), SCANNER.nextLine());
        }

        static void output(Object output) {
            System.out.println(output);
        }
    }
}