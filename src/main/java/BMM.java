import java.math.BigInteger;
import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/305

*/

public class BMM {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(gcd(input.a, input.b));
    }

    private static BigInteger gcd(BigInteger a, BigInteger b) {
        if (b.equals(BigInteger.ZERO)) {
            return a;
        } else {
            return gcd(b, a.remainder(b));
        }
    }

    private record IO(BigInteger a, BigInteger b) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            return new IO(SCANNER.nextBigInteger(), SCANNER.nextBigInteger());
        }

        static void output(Object output) {
            System.out.println(output);
        }
    }
}