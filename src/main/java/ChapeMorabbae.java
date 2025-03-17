import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/591

*/

public class ChapeMorabbae {
    public static void main(String[] args) {
        squarePrint();
    }

    private static void squarePrint() {
        System.out.println(squareBuilder(Input.getInput().n()));
    }

    private static StringBuilder squareBuilder(int n) {
        StringBuilder square = new StringBuilder();

        String horizontalSide = String.valueOf('*').repeat(n) + '\n';
        String verticalSide = '*' + String.valueOf(' ').repeat(n - 2) + '*' + '\n';

        square.append(horizontalSide);
        square.append(verticalSide.repeat(n - 2));
        square.append(horizontalSide);

        return square;
    }

    private record Input(int n) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static Input getInput() {
            return new Input(SCANNER.nextInt());
        }
    }
}


