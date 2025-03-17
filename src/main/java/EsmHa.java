import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

/*

  Problem link: https://quera.org/problemset/2529

*/

public class EsmHa {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(countDifferentLetters(input.names));
    }

    private static int countDifferentLetters(String[] names) {
        AtomicInteger maxDifferentLetters = new AtomicInteger();

        Arrays.stream(names).forEach(name -> {
            int differentLetters = new HashSet<>() {{
                addAll(List.of(name.split("")));
            }}.size();

            maxDifferentLetters.set(Math.max(differentLetters, maxDifferentLetters.get()));
        });

        return maxDifferentLetters.get();
    }

    private record IO(String[] names) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            int n = SCANNER.nextInt();
            SCANNER.nextLine();

            String[] names = new String[n];
            for (int i = 0; i < n; i++) {
                names[i] = SCANNER.nextLine();
            }

            return new IO(names);
        }

        static void output(Object output) {
            System.out.println(output);
        }
    }
}