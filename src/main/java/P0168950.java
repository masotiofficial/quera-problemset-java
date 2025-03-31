import java.util.Arrays;
import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/168950

*/

public class P0168950 {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(determineSeason(input.month));
    }

    private static String determineSeason(String month) {
        return Seasons.getSeason(month).name;
    }

    private enum Seasons {
        SPRING("spring", new String[]{"september", "october", "november"}),
        SUMMER("summer", new String[]{"december", "january", "february"}),
        AUTUMN("autumn", new String[]{"march", "april", "may"}),
        WINTER("winter", new String[]{"june", "july", "august"});

        final String name;
        final String[] months;

        Seasons(String name, String[] months) {
            this.name = name;
            this.months = months;
        }

        public static Seasons getSeason(String month) {
            return Arrays.stream(values())
                    .filter(season -> Arrays.asList(season.months).contains(month))
                    .findFirst()
                    .orElse(null);
        }
    }

    private record IO(String month) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            return new IO(SCANNER.nextLine());
        }

        static void output(Object output) {
            System.out.println(output);
        }
    }
}