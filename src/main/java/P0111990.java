import java.util.Arrays;
import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/111990

*/

public class P0111990 {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(findBank(input.day));
    }

    private static String findBank(String day) {
        return Days.fromString(day).bank;
    }

    private enum Days {
        SHANBE("shanbe", "perspolis"),
        YEKSHANBE("yekshanbe", "bahman"),
        DOSHANBE("doshanbe", "perspolis"),
        SESHANBE("seshanbe", "bahman"),
        CHAHARSHANBE("chaharshanbe", "perspolis"),
        PANJSHANBE("panjshanbe", "bahman"),
        JOME("jome", "tatil");

        final String name;
        final String bank;

        Days(String name, String bank) {
            this.name = name;
            this.bank = bank;
        }

        public static Days fromString(String name) {
            return Arrays.stream(Days.values())
                    .filter(days -> days.name.equals(name))
                    .findFirst()
                    .orElse(null);
        }
    }

    private record IO(String day) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            return new IO(SCANNER.nextLine());
        }

        static void output(Object output) {
            System.out.println(output);
        }
    }
}