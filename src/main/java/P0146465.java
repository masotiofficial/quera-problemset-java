import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/146465

*/

public class P0146465 {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(isPossibleEat(input.n(), input.k()) ? "YES" : "NO");
    }

    private static boolean isPossibleEat(int chocolateCount, int intervalLength) {
        return chocolateCount % intervalLength == 0;
    }

    private record IO(int n, int k) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            return new IO(SCANNER.nextInt(), SCANNER.nextInt());
        }

        static void output(Object output) {
            System.out.println(output);
        }
    }
}