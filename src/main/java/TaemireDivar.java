import java.util.Arrays;
import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/6580

*/

public class TaemireDivar {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(identifyPerson(input.x, input.y, input.r, input.dx, input.dy));
    }

    private static String identifyPerson(int x, int y, int r, int dx, int dy) {
        if (((dx >= x) && (dx <= x + r)) && ((dy >= y - r) && (dy <= y))) {
            return "Mahdi";
        } else {
            return "Parsa";
        }
    }

    private record IO(int x, int y, int r, int dx, int dy) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            return new IO(SCANNER.nextInt(), SCANNER.nextInt(), SCANNER.nextInt(), SCANNER.nextInt(), SCANNER.nextInt());
        }

        static void output(Object output) {
            System.out.println(output);
        }
    }
}