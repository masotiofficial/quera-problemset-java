import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/132247

*/

public class P0132247 {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(findFakeGrave(input.names));
    }

    private static String findFakeGrave(Map<String, Integer> names) {
        return names.entrySet().stream()
                .filter(entry -> entry.getValue() % 2 != 0)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);
    }

    private record IO(Map<String, Integer> names) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            int n = SCANNER.nextInt();

            Map<String, Integer> names = new HashMap<>();
            for (int i = 0; i < 2 * n - 1; i++) {
                String name = SCANNER.next();

                names.compute(name, (key, value) -> value == null ? 1 : value + 1);
            }

            return new IO(names);
        }

        static void output(Object output) {
            System.out.println(output);
        }
    }
}