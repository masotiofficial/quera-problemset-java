import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/145639

*/

public class KhanaBarayeEnsan {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO.input();
    }

    private static String convertUnit(int m) {
        if (m < 1024) {
            return m + "B";
        } else if (m < 1024 * 1024) {
            return m / 1024 + "KiB";
        } else {
            return m / (1024 * 1024) + "MiB";
        }
    }

    private record IO() {
        private static final Scanner SCANNER = new Scanner(System.in);

        static void input() {
            int T = SCANNER.nextInt();

            for (int i = 0; i < T; i++) {
                output(convertUnit(SCANNER.nextInt()));
            }
        }

        static void output(Object output) {
            System.out.println(output);
        }
    }
}