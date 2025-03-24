import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*

  Problem link: https://quera.org/problemset/187843

*/

public class MarDarJadval {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(Arrays.stream(buildTable(input.n, input.m))
                .map(row -> Arrays.stream(row)
                        .mapToObj(String::valueOf)
                        .collect(Collectors.joining(" ")))
                .collect(Collectors.joining("\n"))
        );
    }

    private static int[][] buildTable(int n, int m) {
        return IntStream.range(0, n)
                .mapToObj(i -> IntStream.range(0, m)
                        .map(j -> (i + 1) * m - (i % 2 == 0 ? m - 1 - j : j))
                        .toArray()
                ).toArray(int[][]::new);
    }

    private record IO(int n, int m) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            return new IO(SCANNER.nextInt(), SCANNER.nextInt());
        }

        static void output(Object output) {
            System.out.println(output);
        }
    }
}