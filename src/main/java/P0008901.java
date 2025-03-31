import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/8901

*/

public class P0008901 {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(findFinalCup(input.x, input.moves));
    }

    private static char findFinalCup(char startCup, Move[] moves) {
        for (Move move : moves) {
            if (move.source == startCup) {
                startCup = move.target;
            } else if (move.target == startCup) {
                startCup = move.source;
            }
        }

        return startCup;
    }

    private record Move(char source, char target) {
    }

    private record IO(char x, Move[] moves) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            int n = SCANNER.nextInt();
            char x = SCANNER.next().charAt(0);

            Move[] moves = new Move[n];
            for (int i = 0; i < n; i++) {
                moves[i] = new Move(SCANNER.next().charAt(0), SCANNER.next().charAt(0));
            }

            return new IO(x, moves);
        }

        static void output(Object output) {
            System.out.print(output);
        }
    }
}