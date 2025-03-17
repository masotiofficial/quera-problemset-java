import java.math.BigInteger;
import java.util.Scanner;

/*

  Problem link: http://quera.org/problemset/594

*/

public class Mabna {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(add(input.a, input.b) ? "Yes" : "No");
    }

    private static boolean add(int a, int b) {
        String c = Integer.toUnsignedString(a, b);

        BigInteger sum_1 = BigInteger.ZERO;
        BigInteger sum_2 = BigInteger.ZERO;
        BigInteger digit;
        for (int i = 0; i < c.length(); i++) {
            digit = BigInteger.valueOf(c.charAt(i) - '0');

            if (i % 2 == 0) {
                sum_1 = sum_1.add(digit);
            } else {
                sum_2 = sum_2.add(digit);
            }
        }

        return sum_1.equals(sum_2);
    }

    private record IO(int a, int b) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            return new IO(SCANNER.nextInt(), SCANNER.nextInt());
        }

        static void output(Object output) {
            System.out.println(output);
        }
    }
}