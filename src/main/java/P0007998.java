import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*

  Problem link: https://quera.org/problemset/7998

*/

public class P0007998 {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(determineElectoralName(input.n, input.keys));
    }

    private static String determineElectoralName(int n, String[] keys) {
        AtomicBoolean isCaps = new AtomicBoolean(false);

        return IntStream.range(0, n).mapToObj(i -> {
            if (keys[i].equals("CAPS")) {
                isCaps.set(!isCaps.get());

                return "";
            } else {
                if (isCaps.get()) {
                    return keys[i].toUpperCase();
                } else {
                    return keys[i].toLowerCase();
                }
            }
        }).collect(Collectors.joining());
    }

    private record IO(int n, String[] keys) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            int n = SCANNER.nextInt();

            String[] keys = new String[n];
            for (int i = 0; i < n; i++) {
                keys[i] = SCANNER.next();
            }

            return new IO(n, keys);
        }

        static void output(Object output) {
            System.out.print(output);
        }
    }
}