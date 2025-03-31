import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/275457

*/

public class P0275457 {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(hasEnoughRegistrations(input.n()) ? "Yes" : "No");
    }

    private static boolean hasEnoughRegistrations(int numberOfRegistrations) {
        return numberOfRegistrations > 50;
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