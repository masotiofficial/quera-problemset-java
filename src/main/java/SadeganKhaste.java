import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/3406

*/

public class SadeganKhaste {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(compare(input.a, input.b));
    }

    private static String compare(String a, String b) {
        String revertedA = reverse(a);
        String revertedB = reverse(b);

        int comparison = revertedA.compareTo(revertedB);

        if (comparison == 0) {
            return a + " = " + b;
        } else if (comparison < 0) {
            return a + " < " + b;
        } else {
            return b + " < " + a;
        }
    }

    public static String reverse(String number) {
        return new StringBuilder(number).reverse().toString();
    }

    private record IO(String a, String b) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            return new IO(SCANNER.nextLine(), SCANNER.nextLine());
        }

        static void output(Object output) {
            System.out.println(output);
        }
    }
}