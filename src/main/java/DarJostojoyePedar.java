import java.util.Arrays;
import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/287

*/

public class DarJostojoyePedar {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(String.join("\n", findFathers(input.t, input.numbers)));
    }

    private static String[] findFathers(int length, int[] numbers) {
        String[] result = new String[length];

        for (int i = 0; i < length; i++) {
            result[i] = hasFather(numbers[i]) ? "Yes" : "No";
        }

        return result;
    }

    private static boolean hasFather(int number) {
        boolean result = false;

        for (int i = 1; i < number; i++) {
            int father = i + sumOfDigits(i) + sumOfPrimeFactors(i);

            if (father == number) {
                result = true;

                break;
            }
        }

        return result;
    }

    private static int sumOfDigits(int number) {
        return Arrays.stream(String.valueOf(number).split(""))
                .mapToInt(Integer::parseInt)
                .sum();
    }

    private static int sumOfPrimeFactors(int number) {
        int result = 0;

        for (int i = 1; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                if (isPrime(i)) {
                    result += i;
                }

                int divisor = number / i;
                if ((i != divisor) && (isPrime(divisor))) {
                    result += divisor;
                }
            }
        }

        return result;
    }

    private static boolean isPrime(int number) {
        if (number == 1) return false;
        if (number == 2) return true;
        if (number == 3) return true;
        if (number % 2 == 0) return false;
        if (number % 3 == 0) return false;
        else {
            for (int i = 5; i * i <= number; i += 6) {
                if (number % i == 0) return false;
                else if (number % (i + 2) == 0) return false;
            }

            return true;
        }
    }

    private record IO(int t, int[] numbers) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            int t = SCANNER.nextInt();

            int[] numbers = new int[t];
            for (int i = 0; i < t; i++) {
                numbers[i] = SCANNER.nextInt();
            }

            return new IO(t, numbers);
        }

        static void output(Object output) {
            System.out.println(output);
        }
    }
}