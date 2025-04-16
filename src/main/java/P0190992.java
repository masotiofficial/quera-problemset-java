import java.time.Duration;
import java.time.LocalTime;
import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/190992

*/

public class P0190992 {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(calculateDifferenceBetweenTwoTimes(input.t1(), input.t2()));
    }

    private static String calculateDifferenceBetweenTwoTimes(String startTime, String endTime) {
        LocalTime startLocalTime = LocalTime.parse(startTime);
        LocalTime endLocalTime = LocalTime.parse(endTime);

        Duration duration = Duration.between(startLocalTime, endLocalTime);

        return formattedDuration(duration);
    }

    private static String formattedDuration(Duration duration) {
        if (duration.isNegative() || duration.isZero()) {
            duration = duration.plusDays(1);
        }

        long hours = duration.toHours();
        long minutes = duration.toMinutes() % 60;
        long seconds = duration.getSeconds() % 60;

        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }

    private record IO(String t1, String t2) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            return new IO(SCANNER.nextLine(), SCANNER.nextLine());
        }

        static void output(Object output) {
            System.out.print(output);
        }
    }
}