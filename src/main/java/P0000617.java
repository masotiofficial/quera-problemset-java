import java.util.Scanner;
import java.util.stream.IntStream;

/*

  Problem link: https://quera.org/problemset/617

*/

public class P0000617 {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO.output(isInverted(IO.input().n) ? "YES" : "NO");
    }

    private static boolean isInverted(String number) {
        return IntStream.range(0, number.length())
                .allMatch(i -> number.charAt(i) == number.charAt(number.length() - 1 - i));
    }

    private record IO(String n) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            return new IO(SCANNER.nextLine());
        }

        static void output(Object output) {
            System.out.println(output);
        }
    }
}