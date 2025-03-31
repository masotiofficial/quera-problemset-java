import java.math.BigInteger;
import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/637

*/

public class P0000637 {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(add(input.numbers));
    }

    private static BigInteger add(BigInteger[] numbers) {
        BigInteger result = BigInteger.ZERO;

        for (BigInteger number : numbers) {
            result = result.add(number);
        }

        return result;
    }

    private record IO(BigInteger[] numbers) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            int n = SCANNER.nextInt();

            BigInteger[] numbers = new BigInteger[n];
            for (int i = 0; i < n; i++) {
                numbers[i] = SCANNER.nextBigInteger();
            }

            return new IO(numbers);
        }

        static void output(Object output) {
            System.out.println(output);
        }
    }
}