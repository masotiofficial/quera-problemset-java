import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*

  Problem link: https://quera.org/problemset/592

*/

public class P0000592 {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(findAllMods(input.a(), input.b())
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" "))
        );
    }

    private static IntStream findAllMods(int a, int b) {
        int min = Math.min(a, b);
        int max = Math.max(a, b);

        return IntStream.range(2, max - min + 1)
                .filter(i -> (max - min) % i == 0);
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