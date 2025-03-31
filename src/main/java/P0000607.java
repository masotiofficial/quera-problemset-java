import java.util.Arrays;
import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/607

*/

public class P0000607 {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        Arrays.stream(multiply(input.x, input.y, input.z, input.a, input.b)).forEach(row -> {
            Arrays.stream(row).forEach(cell -> IO.output(cell + " "));

            IO.output("\n");
        });
    }

    private static int[][] multiply(int x, int y, int z, int[][] a, int[][] b) {
        int[][] result = new int[x][z];

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < z; j++) {
                for (int k = 0; k < y; k++) {
                    result[i][j] += a[i][k] * b[k][j];
                }
            }
        }

        return result;
    }

    private record IO(int x, int y, int z, int[][] a, int[][] b) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            int x = SCANNER.nextInt();
            int y = SCANNER.nextInt();
            int z = SCANNER.nextInt();

            int[][] a = new int[x][y];
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    a[i][j] = SCANNER.nextInt();
                }
            }

            int[][] b = new int[y][z];
            for (int i = 0; i < y; i++) {
                for (int j = 0; j < z; j++) {
                    b[i][j] = SCANNER.nextInt();
                }
            }

            return new IO(x, y, z, a, b);
        }

        static void output(Object output) {
            System.out.print(output);
        }
    }
}