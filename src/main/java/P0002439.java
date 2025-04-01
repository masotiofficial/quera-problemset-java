import java.math.BigInteger;
import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/2439

*/

public class P0002439 {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(countDigitInFactorialDayBirth(input.dayBirth(), input.selectedDigit()));
    }

    private static long countDigitInFactorialDayBirth(int dayBirth, int selectedDigit) {
        BigInteger factorialDayBirth = factorial(dayBirth);

        return factorialDayBirth.toString().chars()
                .filter(digit -> digit - '0' == selectedDigit)
                .count();
    }

    private static BigInteger factorial(int number) {
        BigInteger factorial = BigInteger.ONE;

        for (int i = 1; i <= number; i++) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }

        return factorial;
    }

    private record IO(int dayBirth, int selectedDigit) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            return new IO(SCANNER.nextInt(), SCANNER.nextInt());
        }

        static void output(Object output) {
            System.out.print(output);
        }
    }
}