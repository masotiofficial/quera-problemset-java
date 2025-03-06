import java.util.*;

/*

  Problem link: https://quera.org/problemset/221452

*/

public class JameDoAdad {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(sum(input.a, input.b));
    }

    private static int sum(int a, int b) {
        return a + b;
    }

    private record IO(int a, int b) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            return new IO(SCANNER.nextInt(), SCANNER.nextInt());
        }

        static void output(Object output) {
            System.out.println(output);
        }
    }
}