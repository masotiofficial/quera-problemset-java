import java.util.Scanner;
import java.util.stream.IntStream;

/*

  Problem link: https://quera.org/problemset/66863

*/

public class P0066863 {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(findNthPrimePalindrome(input.n, input.k));
    }

    private static int findNthPrimePalindrome(int n, int k) {
        int result = 0;

        int count = 0;
        int number = 2;
        while (count < n) {
            if (isPrime(number) && isPalindrome(convertBase(number, k))) {
                count++;

                result = number;
            }

            number++;
        }

        return result;
    }

    private static String convertBase(int n, int base) {
        return Integer.toString(n, base);
    }

    private static boolean isPalindrome(String n) {
        char[] digits = n.toCharArray();

        return IntStream.range(0, digits.length / 2)
                .allMatch(i -> digits[i] == digits[digits.length - 1 - i]);
    }

    private static boolean isPrime(int n) {
        if (n == 1) {
            return false;
        } else if (n == 2) {
            return true;
        } else if (n == 3) {
            return true;
        } else if ((n % 2 == 0) || (n % 3 == 0)) {
            return false;
        } else {
            for (int i = 5; i * i <= n; i += 6) {
                if ((n % i == 0) || (n % (i + 2) == 0)) {
                    return false;
                }
            }

            return true;
        }
    }

    private record IO(int n, int k) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            return new IO(SCANNER.nextInt(), SCANNER.nextInt());
        }

        static void output(Object output) {
            System.out.println(output);
        }
    }
}