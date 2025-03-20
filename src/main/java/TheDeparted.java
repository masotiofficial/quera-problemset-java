import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*

  Problem link: https://quera.org/problemset/132251

*/

public class TheDeparted {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        int[] indexes = getJetsCodeIndex(input.codes());
        IO.output(indexes.length == 0 ? "HE GOT AWAY!" : formatIndexes(indexes));
    }

    private static String formatIndexes(int[] indexes) {
        return Arrays.stream(indexes)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" "));
    }

    private static int[] getJetsCodeIndex(String[] codes) {
        return IntStream.range(0, codes.length)
                .filter(i -> codes[i].contains("FBI"))
                .map(i -> i + 1)
                .toArray();
    }

    private record IO(String[] codes) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            String[] codes = new String[5];

            for (int i = 0; i < 5; i++) {
                codes[i] = SCANNER.nextLine();
            }

            return new IO(codes);
        }

        static void output(Object output) {
            System.out.println(output);
        }
    }
}