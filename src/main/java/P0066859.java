import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/66859

*/

public class P0066859 {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(convertToBase(input.n, input.b));
    }

    private static String convertToBase(int number, int base) {
        return Integer.toUnsignedString(number, base).toUpperCase();
    }

    private record IO(int n, int b) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            return new IO(SCANNER.nextInt(), SCANNER.nextInt());
        }

        static void output(Object output) {
            System.out.println(output);
        }
    }
}