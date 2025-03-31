import java.util.Arrays;
import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/211019

*/

public class P0211019 {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(getStoneColor(input.stoneName));
    }

    private static String getStoneColor(String stoneName) {
        return Arrays.stream(Stone.values())
                .filter(stone -> stone.name().equalsIgnoreCase(stoneName))
                .map(stone -> stone.color)
                .findFirst()
                .orElse("UNKNOWN");
    }

    private enum Stone {
        SPACE("space", "blue"),
        Mind("mind", "yellow"),
        REALITY("reality", "red"),
        POWER("power", "purple"),
        TIME("time", "green"),
        SOUL("soul", "orange");

        final String name;
        final String color;

        Stone(String name, String color) {
            this.name = name;
            this.color = color;
        }
    }

    private record IO(String stoneName) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            return new IO(SCANNER.nextLine());
        }

        static void output(Object output) {
            System.out.println(output);
        }
    }
}