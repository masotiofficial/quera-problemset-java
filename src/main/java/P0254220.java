import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/*

  Problem link: https://quera.org/problemset/254220

*/

public class P0254220 {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(String.join("\n", playWordleGame(input.key(), input.guessCount(), input.guesses())));
    }

    private static String[] playWordleGame(String key, int guessCount, String[] guesses) {
        String[] result = new String[guessCount];

        boolean isGuessed = false;
        for (int i = 0; i < guessCount; i++) {
            String guess = guesses[i];

            if (isGuessed) {
                result[i] = "Game Over";
            } else if (guess.length() != key.length()) {
                result[i] = "Invalid Length";
            } else {
                Map<Character, Long> keyLettersCount = key.chars()
                        .mapToObj(letter -> (char) letter)
                        .collect(Collectors.groupingBy(letter -> letter, Collectors.counting()));

                result[i] = "";

                for (int j = 0; j < guess.length(); j++) {
                    char keyLetter = key.charAt(j);
                    char guessLetter = guess.charAt(j);

                    if (keyLetter == guessLetter) {
                        result[i] += "G";

                        keyLettersCount.put(guessLetter, keyLettersCount.getOrDefault(guessLetter, 1L) - 1);
                    } else {
                        result[i] += "X";
                    }
                }

                StringBuilder tempResult = new StringBuilder(result[i]);
                for (int j = 0; j < guess.length(); j++) {
                    if (tempResult.charAt(j) == 'X') {
                        char guessLetter = guess.charAt(j);

                        if ((key.indexOf(guessLetter) != -1) && (keyLettersCount.getOrDefault(guessLetter, 0L) != 0)) {
                            tempResult.setCharAt(j, 'Y');

                            keyLettersCount.put(guessLetter, keyLettersCount.getOrDefault(guessLetter, 1L) - 1);
                        } else {
                            tempResult.setCharAt(j, 'R');
                        }
                    }
                }

                result[i] = tempResult.toString();

                isGuessed = guess.equals(key);
            }
        }

        return result;
    }

    private record IO(String key, int guessCount, String[] guesses) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            String key = SCANNER.nextLine();
            int guessCount = Integer.parseInt(SCANNER.nextLine());

            String[] guesses = new String[guessCount];
            for (int i = 0; i < guessCount; i++) {
                guesses[i] = SCANNER.nextLine();
            }

            return new IO(key, guessCount, guesses);
        }

        static void output(Object output) {
            System.out.println(output);
        }
    }
}