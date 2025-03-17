import java.util.*;

/*

  Problem link: https://quera.org/problemset/261557

*/

public class SagheTalayeShokolati {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(chocolateWeight(input.n, input.x, input.k));
    }

    private static int chocolateWeight(int n, int x, int k) {
        return (k - 1) * x;
    }

    private record IO(int n, int x, int k) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            return new IO(SCANNER.nextInt(), SCANNER.nextInt(), SCANNER.nextInt());
        }

        static void output(Object output) {
            System.out.println(output);
            ;
        }
    }
}