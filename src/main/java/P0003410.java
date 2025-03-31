import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

/*

  Problem link: https://quera.org/problemset/3410

*/

public class P0003410 {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        Arrays.stream(khayyamPascalTriangle(input.n))
                .map(row -> Arrays.stream(row)
                        .mapToObj(String::valueOf)
                        .collect(Collectors.joining(" ")))
                .forEach(IO::output);
    }

    private static int[][] khayyamPascalTriangle(int n) {
        int[][] triangle = new int[n][];

        for (int i = 0; i < n; i++) {
            triangle[i] = new int[i + 1];

            for (int j = 0; j < i + 1; j++) {
                if ((j == 0) || (j == i)) {
                    triangle[i][j] = 1;
                } else {
                    triangle[i][j] = triangle[i - 1][j] + triangle[i - 1][j - 1];
                }
            }
        }

        return triangle;
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