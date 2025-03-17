import java.util.Arrays;
import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/588

*/

public class Maximum {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO.output(maximum(IO.input().numbers));
    }

    private static int maximum(int[] numbers) {
        return Arrays.stream(numbers).max().getAsInt();
    }

    private record IO(int[] numbers) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            int n = SCANNER.nextInt();

            int[] numbers = new int[n];
            for (int i = 0; i < n; i++) {
                numbers[i] = SCANNER.nextInt();
            }

            return new IO(numbers);
        }

        static void output(Object output) {
            System.out.println(output);
        }
    }
}