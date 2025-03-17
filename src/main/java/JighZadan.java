import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/175187

*/

public class JighZadan {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(minNumberOfScreams(input.n));
    }

    private static int minNumberOfScreams(int n) {
        if (n == 1) {
            return 2;
        } else {
            return 3;
        }
    }

    private record IO(int n) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            return new IO(SCANNER.nextInt());
        }

        static void output(Object output) {
            System.out.println(output);
        }
    }
}