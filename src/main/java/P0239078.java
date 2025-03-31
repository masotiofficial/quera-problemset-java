import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/239078

*/

public class P0239078 {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(otherSideOfDice(input.n));
    }

    private static int otherSideOfDice(int n) {
        return -n + 7;
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