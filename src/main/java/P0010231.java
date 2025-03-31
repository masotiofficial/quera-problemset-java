import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/*

  Problem link: https://quera.org/problemset/10231

*/

public class P0010231 {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        Arrays.stream(exam(input.strings))
                .mapToObj(i -> (i + 1) + " ")
                .forEach(IO::output);
    }

    private static int[] exam(String[] strings) {
        return IntStream.range(0, strings.length)
                .filter(i -> strings[i].contains("MOLANA") || strings[i].contains("HAFEZ"))
                .toArray();
    }

    private record IO(String[] strings) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            String[] strings = new String[5];

            for (int i = 0; i < 5; i++) {
                strings[i] = SCANNER.nextLine();
            }

            return new IO(strings);
        }

        static void output(Object output) {
            System.out.print(output);
        }
    }
}