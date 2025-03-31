import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/*

  Problem link: https://quera.org/problemset/3538

*/

public class P0003538 {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(determineDay(input.days));
    }

    private static int determineDay(Set<String> days) {
        return 7 - days.size();
    }

    private record IO(Set<String> days) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            Set<String> days = new HashSet<>();

            for (int i = 0; i < 3; i++) {
                int numberOfDays = SCANNER.nextInt();

                for (int j = 0; j < numberOfDays; j++) {
                    days.add(SCANNER.next());
                }
            }

            return new IO(days);
        }

        static void output(Object output) {
            System.out.print(output);
        }
    }
}