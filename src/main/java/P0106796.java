import java.util.Scanner;
import java.util.stream.Collectors;

/*

  Problem link: https://quera.org/problemset/106796

*/

public class P0106796 {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(encrypt(input.n(), input.k(), input.message()));
    }

    private static String encrypt(int n, int k, String message) {
        String result = message;

        for (int i = 1; i <= k; i++) {
            result = result.charAt(n - 1) + result.substring(0, n - 1);

            result = result.chars()
                    .map(letter -> (letter - 'a' + 1) % 26 + 'a')
                    .mapToObj(character -> String.valueOf((char) character))
                    .collect(Collectors.joining());
        }

        return result;
    }

    private record IO(int n, int k, String message) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            return new IO(Integer.parseInt(SCANNER.nextLine()), Integer.parseInt(SCANNER.nextLine()), SCANNER.nextLine());
        }

        static void output(Object output) {
            System.out.print(output);
        }
    }
}