import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/2886

*/

public class P0002886 {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(formattedClock(input.a(), input.b()));
    }

    private static String formattedClock(int hour, int minute) {
        int formattedHour = hour == 0 ? 0 : 12 - hour;
        int formattedMinute = minute == 0 ? 0 : 60 - minute;

        return String.format("%02d:%02d", formattedHour, formattedMinute);
    }

    private record IO(int a, int b) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            return new IO(SCANNER.nextInt(), SCANNER.nextInt());
        }

        static void output(Object output) {
            System.out.print(output);
        }
    }
}