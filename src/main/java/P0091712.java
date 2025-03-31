import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/91712

*/

public class P0091712 {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(findDirection(input.x_1, input.x_2));
    }

    private static String findDirection(int x_1, int x_2) {
        int difference = x_2 - x_1;
        int moves = Math.abs(difference);

        if (difference == 0) {
            return "Saal Noo Mobarak!";
        } else {
            if (difference < 0) {
                return "L".repeat(moves);
            } else {
                return "R".repeat(moves);
            }
        }
    }

    private record IO(int x_1, int x_2) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            return new IO(SCANNER.nextInt(), SCANNER.nextInt());
        }

        static void output(Object output) {
            System.out.println(output);
        }
    }
}