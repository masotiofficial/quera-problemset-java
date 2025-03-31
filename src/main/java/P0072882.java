import java.util.Arrays;
import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/72882

*/

public class P0072882 {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(countMeats(input.firstContainer) + " " + countMeats(input.secondContainer));
    }

    private static long countMeats(String[] container) {
        return Arrays.stream(container)
                .mapToLong(row -> row.chars()
                        .filter(ch -> ch == '*')
                        .count())
                .sum();
    }

    private record IO(String[] firstContainer, String[] secondContainer) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            int n = SCANNER.nextInt();
            int m = SCANNER.nextInt();
            SCANNER.nextLine();

            String[] firstContainer = new String[n];
            for (int i = 0; i < n; i++) {
                firstContainer[i] = SCANNER.nextLine();
            }

            String[] secondContainer = new String[n];
            for (int i = 0; i < n; i++) {
                secondContainer[i] = SCANNER.nextLine();
            }

            return new IO(firstContainer, secondContainer);
        }

        static void output(Object output) {
            System.out.println(output);
        }
    }
}