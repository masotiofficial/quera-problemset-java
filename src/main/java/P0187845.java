import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/187845

*/

public class P0187845 {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(isCorrectCondition(input.n(), input.m()) ? "Yes" : "No");
    }

    private static boolean isCorrectCondition(int pigeons, int nests) {
        return pigeons > nests;
    }

    private record IO(int n, int m) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            return new IO(SCANNER.nextInt(), SCANNER.nextInt());
        }

        static void output(Object output) {
            System.out.print(output);
        }
    }
}