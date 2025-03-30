import java.util.HashMap;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/*

  Problem link: https://quera.org/problemset/236442

*/

public class RozHayeKamJenaiat {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(minAverageCrimeRatePerDay(input.days()));
    }

    private static String minAverageCrimeRatePerDay(Day[] days) {
        Map<String, List<Day>> daysByName = Arrays.stream(days).collect(Collectors.groupingBy(day -> day.name));

        Map<String, Double> averageCrimeRatePerDay = new HashMap<>();
        for (Map.Entry<String, List<Day>> entry : daysByName.entrySet()) {
            averageCrimeRatePerDay.put(
                    entry.getKey(),
                    entry.getValue().stream()
                            .mapToInt(day -> day.crimeRate)
                            .average()
                            .orElse(0.0)
            );
        }

        Map.Entry<String, Double> minDay = averageCrimeRatePerDay.entrySet().stream()
                .min(Map.Entry.comparingByValue())
                .orElseThrow(() -> new IllegalStateException("No days found"));

        return minDay.getKey() + " " + minDay.getValue().intValue();
    }

    private record Day(int number, String name, int crimeRate) {

        public static Map<Integer, String> names(String firstDayMonth, int daysMonth) {
            List<String> days = List.of(
                    "Saturday",
                    "Sunday",
                    "Monday",
                    "Tuesday",
                    "Wednesday",
                    "Thursday",
                    "Friday"
            );

            int indexOfFirstDayMonth = days.indexOf(firstDayMonth);

            Map<Integer, String> numbers = new HashMap<>();
            for (int dayNumber = 0; dayNumber < daysMonth; dayNumber++) {
                int dayIndex = (indexOfFirstDayMonth + dayNumber) % 7;

                numbers.put(dayNumber, days.get(dayIndex));
            }

            return numbers;
        }
    }

    private record IO(Day[] days) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            int daysMonth = 30;

            String firstDayMonth = SCANNER.nextLine();
            Map<Integer, String> names = Day.names(firstDayMonth, daysMonth);

            Day[] days = new Day[daysMonth];
            for (int i = 0; i < daysMonth; i++) {
                days[i] = new Day(i + 1, names.get(i), SCANNER.nextInt());
            }

            return new IO(days);
        }

        static void output(Object output) {
            System.out.println(output);
        }
    }
}