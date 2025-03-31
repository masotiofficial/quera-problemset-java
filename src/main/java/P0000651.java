import java.util.Scanner;
import java.util.stream.IntStream;

/*

  Problem link: https://quera.org/problemset/651

*/

public class P0000651 {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(isPalindromeInNewBase(input.a, input.b, input.c) ? "YES" : "NO");
    }

    private static boolean isPalindromeInNewBase(int number, int sourceBase, int targetBase) {
        int decimalNumber = convertToDecimal(number, sourceBase);
        String newBaseNumber = convertToBase(decimalNumber, targetBase);

        return isPalindrome(newBaseNumber);
    }

    private static boolean isPalindrome(String number) {
        char[] digits = number.toCharArray();

        return IntStream.range(0, digits.length / 2)
                .allMatch(i -> digits[i] == digits[digits.length - 1 - i]);
    }

    private static int convertToDecimal(int number, int base) {
        return Integer.parseInt(String.valueOf(number), base);
    }

    private static String convertToBase(int number, int base) {
        return Integer.toString(number, base);
    }

    private record IO(int a, int b, int c) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            return new IO(SCANNER.nextInt(), SCANNER.nextInt(), SCANNER.nextInt());
        }

        static void output(Object output) {
            System.out.println(output);
        }
    }
}