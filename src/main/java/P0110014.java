import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/110014

*/

public class P0110014 {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(isDoable(input.one(), input.two()) ? "YES" : "NO");
    }

    private static boolean isDoable(HandsFree one, HandsFree two) {
        return (one.right() == one.left()) ||
                (two.right() == two.left()) ||
                (one.right() == two.left()) ||
                (one.left() == two.right());
    }

    private record HandsFree(char right, char left) {
    }

    private record IO(HandsFree one, HandsFree two) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            return new IO(
                    new HandsFree(SCANNER.next().charAt(0), SCANNER.next().charAt(0)),
                    new HandsFree(SCANNER.next().charAt(0), SCANNER.next().charAt(0))
            );
        }

        static void output(Object output) {
            System.out.println(output);
        }
    }
}