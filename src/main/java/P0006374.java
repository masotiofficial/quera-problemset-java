import java.math.BigInteger;
import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/6374

*/

public class P0006374 {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO.output(increaseHexadecimal(IO.input().hexadecimal));
    }

    private static String increaseHexadecimal(String hexadecimal) {
        BigInteger decimal = new BigInteger(hexadecimal, 16);

        decimal = decimal.add(BigInteger.ONE);

        return decimal.toString(16).toUpperCase();
    }

    private record IO(String hexadecimal) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            return new IO(SCANNER.nextLine());
        }

        static void output(Object output) {
            System.out.println(output);
        }
    }
}