import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

/*

  Problem link: https://quera.org/problemset/3431

*/

public class OghateFeraghat {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(countSearchWord(input.rows, input.columns, input.searchWord));
    }

    private static int countSearchWord(String[] rows, String[] columns, String searchWord) {
        AtomicInteger count = new AtomicInteger();

        Arrays.stream(rows)
                .forEach(word ->
                        count.getAndAdd(countOccurrences(word, searchWord))
                );

        Arrays.stream(columns)
                .forEach(word ->
                        count.getAndAdd(countOccurrences(word, searchWord))
                );

        return count.get();
    }

    private static int countOccurrences(String a, String b) {
        return (int) IntStream.range(0, a.length() - b.length() + 1)
                .filter(i -> a.startsWith(b, i))
                .count();
    }

    private record IO(String[] rows, String[] columns, String searchWord) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            int n = SCANNER.nextInt();
            int m = SCANNER.nextInt();
            SCANNER.nextLine();

            String[] rows = new String[n];
            String[] columns = new String[m];
            for (int i = 0; i < n; i++) {
                rows[i] = SCANNER.nextLine();

                for (int j = 0; j < m; j++) {
                    columns[j] = (columns[j] == null ? "" : columns[j]) + rows[i].charAt(j) + "";
                }
            }

            return new IO(rows, columns, SCANNER.nextLine());
        }

        static void output(Object output) {
            System.out.println(output);
        }
    }
}