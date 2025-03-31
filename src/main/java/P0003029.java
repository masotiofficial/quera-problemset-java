import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/3029

*/

public class P0003029 {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(getDirection(input.x, input.x_1));
    }

    private static String getDirection(int x, int x_1) {
        return x_1 <= x ? "Left" : "Right";
    }

    private record IO(int x, int y, int x_1, int y_1) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            return new IO(SCANNER.nextInt(), SCANNER.nextInt(), SCANNER.nextInt(), SCANNER.nextInt());
        }

        static void output(Object output) {
            System.out.println(output);
        }
    }
}