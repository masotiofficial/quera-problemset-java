import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/*

  Problem link: https://quera.org/problemset/655

*/

public class P0000655 {
    public static void main(String[] args) {
        sortedFilms();
    }

    private static void sortedFilms() {
        String[] films = Input.getInput().films();

        for (String film : films) {
            System.out.println(film);
        }
    }

    private record Input(String[] films) {
        private static final Scanner SCANNER = new Scanner(System.in);

        private static final String REGEX = "^[A-Z][a-z]*( [A-Z][a-z]*)*$";
        private static final Pattern PATTERN = Pattern.compile(REGEX);

        static Input getInput() {
            return new Input(getFilms(SCANNER.nextInt()));
        }

        private static String[] getFilms(int n) {
            String[] films = new String[n];

            SCANNER.nextLine();
            for (int i = 0; i < n; i++) {
                String film = SCANNER.nextLine();

                films[i] = Pattern.compile("\\s+")
                        .splitAsStream(film.trim())
                        .filter(word -> !word.isEmpty())
                        .map(word -> word.substring(0, 1).toUpperCase() +
                                (word.length() > 1 ? word.substring(1).toLowerCase() : ""))
                        .collect(Collectors.joining(" "));
            }

            return films;
        }
    }
}