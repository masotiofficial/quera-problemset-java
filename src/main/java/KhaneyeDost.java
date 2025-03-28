import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/176782

*/

public class KhaneyeDost {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(calculateArea(input.n));
    }

    static private int calculateArea(int side) {
        return side * side;
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