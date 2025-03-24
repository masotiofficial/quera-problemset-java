import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/145366

*/

public class HadeaksarYaleGraph {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(maxEdges(input.n));
    }

    private static long maxEdges(long vectors) {
        return vectors * (vectors - 1) / 2;
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