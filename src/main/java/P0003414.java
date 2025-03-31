import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/3414

*/

public class P0003414 {
    public static void main(String[] args) {
        answer();
    }

    private static void answer() {
        Input input = Input.getInput();

        System.out.println(positionDetection(input.x1, input.y1, input.x2, input.y2));
    }

    private static String positionDetection(int x1, int y1, int x2, int y2) {
        if (x1 == x2) {
            return "Vertical";
        } else if (y1 == y2) {
            return "Horizontal";
        } else {
            return "Try again";
        }
    }

    private record Input(int x1, int y1, int x2, int y2) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static Input getInput() {
            return new Input(SCANNER.nextInt(), SCANNER.nextInt(), SCANNER.nextInt(), SCANNER.nextInt());
        }
    }
}
