import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/190993

*/

public class P0190993 {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(String.join("\n", findInDataset(input.dataset(), input.binaryStrings())));
    }

    private static String[] findInDataset(Map<String, String> dataset, String[] binaryStrings) {
        return Arrays.stream(binaryStrings)
                .map(binaryString -> dataset.getOrDefault(binaryString, "Unknown"))
                .toArray(String[]::new);
    }

    private record IO(Map<String, String> dataset, String[] binaryStrings) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            int n = SCANNER.nextInt();
            int q = SCANNER.nextInt();
            int l = SCANNER.nextInt();

            Map<String, String> dataset = new HashMap<>(n);
            for (int i = 0; i < n; i++) {
                dataset.put(SCANNER.next(), SCANNER.next());
            }

            String[] binaryStrings = new String[q];
            for (int i = 0; i < q; i++) {
                binaryStrings[i] = SCANNER.next();
            }

            return new IO(dataset, binaryStrings);
        }

        static void output(Object output) {
            System.out.println(output);
        }
    }
}