import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/183347

*/

public class P0183347 {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(logarithmBaseTwo(input.n));
    }

    private static int logarithmBaseTwo(int n) {
        return (int) (Math.log10(n) / Math.log10(2));
    }

    private record IO(int n) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            return new IO(SCANNER.nextInt());
        }

        static void output(Object output) {
            System.out.print(output);
        }
    }
}