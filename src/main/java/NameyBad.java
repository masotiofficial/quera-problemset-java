import java.util.Scanner;
import java.util.stream.Collectors;

/*

  Problem link: https://quera.org/problemset/7609

*/

public class NameyBad {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(isGoodLetter(input.letter) ? "khoob" : "bad");
    }

    private static boolean isGoodLetter(String letter) {
        return letter.chars().boxed()
                .collect(Collectors.groupingBy(ch -> ch, Collectors.counting()))
                .values().stream()
                .noneMatch(count -> count % 2 != 0);
    }

    private record IO(String letter) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            return new IO(SCANNER.nextLine());
        }

        static void output(Object output) {
            System.out.println(output);
        }
    }
}