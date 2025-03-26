import java.util.Arrays;
import java.util.Scanner;

/*

  Problem link: ]https://quera.org/problemset/275506

*/

public class HezardastanAnnualReport {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(minPages(input.pages));
    }

    private static long minPages(int[] pages) {
        return Arrays.stream(pages)
                .mapToLong(page -> (long) Math.ceil(page / 2.0))
                .sum();
    }

    private record IO(int[] pages) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            int n = SCANNER.nextInt();

            int[] pages = new int[n];
            for (int i = 0; i < n; i++) {
                pages[i] = SCANNER.nextInt();
            }

            return new IO(pages);
        }

        static void output(Object output) {
            System.out.println(output);
        }
    }
}