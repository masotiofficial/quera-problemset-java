import java.util.Scanner;
import java.util.stream.IntStream;

/*

  Problem link: https://quera.org/problemset/8938

*/

public class SnappDarShekarestan {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(calculateCost(input.N, input.M, input.A, input.xy));
    }

    private static int calculateCost(int N, int M, int[][] A, int[][] xy) {
        return IntStream.range(0, M)
                .map(i -> A[xy[i][0] - 1][xy[i][1] - 1])
                .sum();
    }

    private record IO(int N, int M, int[][] A, int[][] xy) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            int N = SCANNER.nextInt();
            int M = SCANNER.nextInt();

            int[][] A = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    A[i][j] = SCANNER.nextInt();
                }
            }

            int[][] xy = new int[M][2];
            for (int i = 0; i < M; i++) {
                xy[i][0] = SCANNER.nextInt();
                xy[i][1] = SCANNER.nextInt();
            }

            return new IO(N, M, A, xy);
        }

        static void output(Object output) {
            System.out.print(output);
        }
    }
}