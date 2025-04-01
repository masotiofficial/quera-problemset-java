import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/634

*/

public class P0000634 {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(String.join(" ", findSpellingMistakes(input.text())));
    }

    private static List<String> findSpellingMistakes(String text) {
        List<String> result = new ArrayList<>();

        String[] words = text.trim().replaceAll("[^a-zA-Z\\s]", " ").split("\\s+");

        for (String word : words) {
            int silentLettersCount = 0;

            for (char letter : word.toCharArray()) {
                if (isSilentLetter(letter) && Character.isLowerCase(letter)) {
                    silentLettersCount++;
                } else {
                    if (silentLettersCount < 5) {
                        silentLettersCount = 0;
                    } else {
                        break;
                    }
                }
            }

            if (silentLettersCount >= 5) {
                result.add(word);
            }
        }

        return result;
    }

    private static boolean isSilentLetter(char letter) {
        return (letter != 'a') && (letter != 'e') && (letter != 'i') && (letter != 'o') && (letter != 'u') && (letter != 'y');
    }

    private record IO(String text) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            return new IO(SCANNER.nextLine());
        }

        static void output(Object output) {
            System.out.println(output);
        }
    }
}