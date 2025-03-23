import java.util.Arrays;
import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/632

*/

public class JostojoyeMaekos {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(search(input.sentence, input.word));
    }

    private static long search(String sentence, String key) {
        String[] words = sentence.replaceAll("[^a-zA-Z\\s]", " ")
                .split("\\s+");

        return Arrays.stream(words)
                .filter(word -> isMatch(word.trim(), key))
                .count();
    }

    private static boolean isMatch(String word, String key) {
        String reversed = new StringBuilder(word).reverse().toString();

        return word.equalsIgnoreCase(key) || reversed.equalsIgnoreCase(key);
    }

    private record IO(String sentence, String word) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            return new IO(SCANNER.nextLine().trim(), SCANNER.nextLine().trim());
        }

        static void output(Object output) {
            System.out.println(output);
        }
    }
}