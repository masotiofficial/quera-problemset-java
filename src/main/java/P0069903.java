import java.util.Scanner;
import java.util.stream.IntStream;

/*

  Problem link: https://quera.org/problemset/69903

*/

public class P0069903 {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(differenceBetweenTwoDates(input.monthOne(), input.dayOne(), input.monthTwo(), input.dayTwo()));
    }

    private static long differenceBetweenTwoDates(int monthOne, int dayOne, int monthTwo, int dayTwo) {
        long totalDaysFirstDate = getDaysBeforeMonth(monthOne) + dayOne;
        long totalDaysSecondDate = getDaysBeforeMonth(monthTwo) + dayTwo;

        return Math.abs(totalDaysFirstDate - totalDaysSecondDate);
    }

    private static long getDaysBeforeMonth(int month) {
        return IntStream.range(1, month)
                .mapToLong(P0069903::monthDays)
                .sum();
    }

    private static int monthDays(int month) {
        if (month <= 6) {
            return 31;
        } else if (month <= 11) {
            return 30;
        } else {
            return 29;
        }
    }

    private record IO(int monthOne, int dayOne, int monthTwo, int dayTwo) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            return new IO(SCANNER.nextInt(), SCANNER.nextInt(), SCANNER.nextInt(), SCANNER.nextInt());
        }

        static void output(Object output) {
            System.out.print(output);
        }
    }
}