import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/181332

*/

public class CSharp {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(repeat(input.n));
    }

    private static String repeat(int n) {
        return "#".repeat(n);
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