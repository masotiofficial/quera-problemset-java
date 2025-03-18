import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/*

  Problem link: https://quera.org/problemset/2636

*/

public class ShatranjeHerfeye {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        Arrays.stream(calculateNeededPieces(input.currentPieces))
                .forEach(piece -> IO.output(piece + " "));
    }

    private static int[] calculateNeededPieces(int[] currentPieces) {
        return IntStream.range(0, 6)
                .map(i -> ChessPiece.values()[i].standardCount - currentPieces[i])
                .toArray();
    }

    private enum ChessPiece {
        KING(1),
        QUEEN(1),
        ROOK(2),
        BISHOP(2),
        KNIGHT(2),
        PAWN(8);

        final int standardCount;

        ChessPiece(int standardCount) {
            this.standardCount = standardCount;
        }
    }

    private record IO(int[] currentPieces) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            int[] currentPieces = new int[6];

            for (int i = 0; i < 6; i++) {
                currentPieces[i] = SCANNER.nextInt();
            }

            return new IO(currentPieces);
        }

        static void output(Object output) {
            System.out.print(output);
        }
    }
}