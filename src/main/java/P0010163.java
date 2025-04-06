import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

/*

  Problem link: https://quera.org/problemset/10163

*/

public class P0010163 {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(calculateCost(input.a(), input.b(), input.c(), input.times()));
    }

    private static int calculateCost(int a, int b, int c, Time[] times) {
        return Arrays.stream(times).flatMapToInt(time -> Arrays.stream(time.range))
                .boxed()
                .collect(Collectors.groupingBy(minute -> minute, Collectors.counting()))
                .values().stream()
                .mapToInt(minute -> minute.intValue() * switch (minute.intValue()) {
                    case 1 -> a;
                    case 2 -> b;
                    case 3 -> c;
                    default -> 0;
                }).sum();
    }

    private static class Time {
        public final int[] range;

        private Time(int checkIn, int checkOut) {
            this.range = new int[checkOut - checkIn];

            Arrays.setAll(range, i -> i + checkIn);
        }
    }

    private record IO(int a, int b, int c, Time[] times) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            int a = SCANNER.nextInt();
            int b = SCANNER.nextInt();
            int c = SCANNER.nextInt();

            Time[] times = new Time[3];
            for (int i = 0; i < 3; i++) {
                times[i] = new Time(SCANNER.nextInt(), SCANNER.nextInt());
            }

            return new IO(a, b, c, times);
        }

        static void output(Object output) {
            System.out.println(output);
        }
    }
}