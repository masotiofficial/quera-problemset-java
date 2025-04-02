import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/*

  Problem link: https://quera.org/problemset/52544

*/

public class P0052544 {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(countDifferentBarcodeStates(input.barcode()));
    }

    private static long countDifferentBarcodeStates(char[][][][] barcode) {
        return IntStream.range(0, 3)
                .mapToLong(i -> IntStream.range(0, 3)
                        .mapToLong(j -> calculateSideStates(i, j, barcode[i][j]))
                        .reduce(1, (a, b) -> a * b))
                .reduce(1, (a, b) -> a * b);
    }

    private static long calculateSideStates(int i, int j, char[][] side) {
        if ((i == 1) || (j == 1)) {
            return calculateMiddleStates(side);
        } else {
            return calculateCornerStates(side);
        }
    }

    private static long calculateMiddleStates(char[][] middle) {
        return IntStream.range(0, 3)
                .mapToLong(i -> IntStream.range(0, 3)
                        .mapToLong(j -> middle[i][j] == '2' ? 2 : 1)
                        .reduce(1, (a, b) -> a * b))
                .reduce(1, (a, b) -> a * b);
    }

    private static long calculateCornerStates(char[][] corner) {
        return IntStream.range(0, 3)
                .mapToLong(i -> IntStream.range(0, 3)
                        .mapToLong(j -> calculateCellCornerStates(i, j, corner[i][j]))
                        .reduce(1, (a, b) -> a * b))
                .reduce(1, (a, b) -> a * b);
    }

    private static int calculateCellCornerStates(int i, int j, char cell) {
        if ((i == 1) && (j == 1)) {
            return switch (cell) {
                case '0', '2' -> 1;
                default -> 0;
            };
        } else {
            return switch (cell) {
                case '1', '2' -> 1;
                default -> 0;
            };
        }
    }

    private record IO(char[][][][] barcode) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            char[][][][] barcode = new char[3][3][3][3];

            for (int i = 0; i < 9; i++) {
                char[] line = SCANNER.nextLine().toCharArray();

                for (int k = 0; k < 3; k++) {
                    barcode[i / 3][k][i - (3 * (i / 3))] = Arrays.copyOfRange(line, 3 * k, 3 * k + 3);
                }
            }

            return new IO(barcode);
        }

        static void output(Object output) {
            System.out.println(output);
        }
    }
}