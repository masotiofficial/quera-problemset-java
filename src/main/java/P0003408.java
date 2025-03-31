import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/3408

*/

public class P0003408 {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(reverse(input.words));
    }

    private static String reverse(List<String> words) {
        List<String> reversed = new ArrayList<>(words);
        Collections.reverse(reversed);

        return String.join(" ", reversed);
    }

    private record IO(List<String> words) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            int n = SCANNER.nextInt();

            List<String> words = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                words.add(SCANNER.next());
            }

            return new IO(words);
        }

        static void output(Object output) {
            System.out.print(output);
        }
    }
}