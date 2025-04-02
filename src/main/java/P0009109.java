import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

/*

  Problem link: https://quera.org/problemset/9109

*/

public class P0009109 {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(minMarkersWithSameColor(input.colors()));
    }

    private static Long minMarkersWithSameColor(int[] colors) {
        return Arrays.stream(colors)
                .mapToLong(Long::valueOf)
                .boxed()
                .collect(Collectors.groupingBy(color -> color, Collectors.counting()))
                .entrySet().stream()
                .min((a, b) -> a.getValue().compareTo(b.getValue()) == 0 ?
                        a.getKey().compareTo(b.getKey()) :
                        a.getValue().compareTo(b.getValue())
                )
                .orElseThrow().getKey();
    }

    private record IO(int[] colors) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            int n = SCANNER.nextInt();

            int[] colors = new int[n];
            for (int i = 0; i < n; i++) {
                colors[i] = SCANNER.nextInt();
            }

            return new IO(colors);
        }

        static void output(Object output) {
            System.out.println(output);
        }
    }
}