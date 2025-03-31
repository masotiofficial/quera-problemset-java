import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

/*

  Problem link: https://quera.org/problemset/142759

*/

public class P0142759 {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(buildString(input.n));
    }

    private static String buildString(int length) {
        return "q".concat(new Random()
                .ints('a', 'z' + 1)
                .limit(Math.max(0, length - 1))
                .mapToObj(letter -> String.valueOf((char) letter))
                .collect(Collectors.joining())
        );
    }

    private record IO(int n) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            return new IO(SCANNER.nextInt());
        }

        static void output(Object output) {
            System.out.println(output);
        }
    }
}