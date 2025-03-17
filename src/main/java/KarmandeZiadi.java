import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/10636

*/

public class KarmandeZiadi {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(minNumberColors(input.n, input.firstAndLastNames));
    }

    private static int minNumberColors(int n, String[] firstAndLastNames) {
        Map<String, Integer> firstNames = new HashMap<>();

        for (String firstAndLastName : firstAndLastNames) {
            String firstName = firstAndLastName.split(" ")[0];

            firstNames.put(firstName, firstNames.getOrDefault(firstName, 0) + 1);
        }

        return Collections.max(firstNames.values());
    }

    private record IO(int n, String[] firstAndLastNames) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            int n = Integer.parseInt(SCANNER.nextLine());

            String[] firstAndLastNames = new String[n];
            for (int i = 0; i < n; i++) {
                firstAndLastNames[i] = SCANNER.nextLine();
            }

            return new IO(n, firstAndLastNames);
        }

        static void output(Object output) {
            System.out.println(output);
        }
    }
}