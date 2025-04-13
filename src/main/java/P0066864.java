import java.util.*;

/*

  Problem link: https://quera.org/problemset/66864

*/

public class P0066864 {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(findDigit(input.k()));
    }

    private static char findDigit(long digitIndex) {
        long digitCount = 1;
        long previousEndDigitIndex = 0;

        long startRange;
        long endRange;
        long startDigitIndex;
        long endDigitIndex;

        while (true) {
            startRange = (long) Math.pow(10, digitCount - 1);
            endRange = (long) Math.pow(10, digitCount) - 1;

            startDigitIndex = previousEndDigitIndex + 1;
            endDigitIndex = startDigitIndex + (endRange - startRange + 1) * digitCount - 1;

            if (digitIndex >= startDigitIndex && digitIndex <= endDigitIndex) {
                break;
            }

            previousEndDigitIndex = endDigitIndex;
            digitCount++;
        }

        long digitsBefore = startDigitIndex - 1;
        long relativeIndex = digitIndex - digitsBefore;
        long numbersBefore = (relativeIndex - 1) / digitCount;
        long number = startRange + numbersBefore;

        char[] numberDigits = String.valueOf(number).toCharArray();
        long digitInNumber = (relativeIndex - 1) % digitCount;

        return numberDigits[(int) digitInNumber];
    }

    private record IO(int k) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            return new IO(SCANNER.nextInt());
        }

        static void output(Object output) {
            System.out.print(output);
        }
    }
}