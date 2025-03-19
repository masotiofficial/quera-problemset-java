import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/72875

*/

public class Joj {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(hasBump(input.n, input.heights) ? "Ey baba :(" : "Bah Bah! Ajab jooji!");
    }

    private static boolean hasBump(int length, int[] heights) {
        boolean result = false;

        for (int i = 1; i < length - 1; i++) {
            result = (heights[i - 1] < heights[i]) && (heights[i] > heights[i + 1]);

            if (result) {
                break;
            }
        }

        return result;
    }

    private record IO(int n, int[] heights) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            int n = SCANNER.nextInt();

            int[] heights = new int[n];
            for (int i = 0; i < n; i++) {
                heights[i] = SCANNER.nextInt();
            }

            return new IO(n, heights);
        }

        static void output(Object output) {
            System.out.println(output);
        }
    }
}