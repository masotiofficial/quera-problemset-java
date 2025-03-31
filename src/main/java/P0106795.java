import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/106795

*/

public class P0106795 {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(isBeautiful(input.a, input.b) ? "YES" : "NO");
    }

    private static boolean isBeautiful(String a, String b) {
        return a.charAt(0) == b.charAt(b.length() - 1);
    }

    private record IO(String a, String b) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            return new IO(SCANNER.nextLine(), SCANNER.nextLine());
        }

        static void output(Object output) {
            System.out.print(output);
        }
    }
}