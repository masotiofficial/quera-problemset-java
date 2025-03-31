import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/14580

*/

public class P0014580 {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(lastChannel(input.n, input.x, input.k, input.channels));
    }

    private static String lastChannel(int channelsCount, int firstChannel, int pressedKeyCount, String[] channels) {
        int startIndex = firstChannel - 1;

        int finalIndex = (startIndex + pressedKeyCount) % channelsCount;

        return channels[finalIndex];
    }

    private record IO(int n, int x, int k, String[] channels) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            int n = SCANNER.nextInt();
            int x = SCANNER.nextInt();
            int k = SCANNER.nextInt();

            SCANNER.nextLine();

            String[] channels = new String[n];
            for (int i = 0; i < n; i++) {
                channels[i] = SCANNER.nextLine();
            }

            return new IO(n, x, k, channels);
        }

        static void output(Object output) {
            System.out.println(output);
        }
    }
}