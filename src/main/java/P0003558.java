import java.util.*;

/*

  Problem link: https://quera.org/problemset/3558

*/

public class P0003558 {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(countOverlapDays(input.firstPersonTimeFrames(), input.secondPersonTimeFrames()));
    }

    private static int countOverlapDays(TimeFrame[] firstPersonTimeFrames, TimeFrame[] secondPersonTimeFrames) {
        List<Integer> result;

        List<Integer> firstPersonDays = TimeFrame.allDays(firstPersonTimeFrames);
        List<Integer> secondPersonDays = TimeFrame.allDays(secondPersonTimeFrames);

        result = firstPersonDays.stream()
                .filter(secondPersonDays::contains)
                .toList();

        return result.size();
    }

    private static class TimeFrame {
        public final int[] days;

        private TimeFrame(int start, int end) {
            this.days = new int[end - start + 1];

            Arrays.setAll(this.days, i -> i + start);
        }

        private static List<Integer> allDays(TimeFrame[] timeFrames) {
            return  Arrays.stream(timeFrames)
                    .flatMapToInt(timeFrame -> Arrays.stream(timeFrame.days))
                    .boxed()
                    .toList();
        }
    }

    private record IO(TimeFrame[] firstPersonTimeFrames, TimeFrame[] secondPersonTimeFrames) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            int n = SCANNER.nextInt();
            int m = SCANNER.nextInt();

            TimeFrame[] firstPersonTimeFrames = new TimeFrame[n];
            for (int i = 0; i < n; i++) {
                firstPersonTimeFrames[i] = new TimeFrame(SCANNER.nextInt(), SCANNER.nextInt());
            }

            TimeFrame[] secondPersonTimeFrames = new TimeFrame[m];
            for (int i = 0; i < m; i++) {
                secondPersonTimeFrames[i] = new TimeFrame(SCANNER.nextInt(), SCANNER.nextInt());
            }

            return new IO(firstPersonTimeFrames, secondPersonTimeFrames);
        }

        static void output(Object output) {
            System.out.print(output);
        }
    }
}