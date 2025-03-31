import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/253399

*/

public class P0253399 {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(finalGoal(input.initialPosition(), input.moves()));
    }

    private static Position finalGoal(Position initialPosition, Move[] moves) {
        Position current = initialPosition;

        for (Move move : moves) {
            current = move.apply(current);
        }

        return current;
    }

    private static class Second extends Move {
        final char currentPlayerHand;
        final char nextPlayerHand;

        private Second(int number, int player, char currentPlayerHand, char nextPlayerHand) {
            super(number, player);

            this.currentPlayerHand = currentPlayerHand;
            this.nextPlayerHand = nextPlayerHand;
        }

        @Override
        Position apply(Position current) {
            if ((current.player == player) && (current.hand == currentPlayerHand)) {
                return new Position(player + 1, nextPlayerHand);
            } else if ((current.player == player + 1) && (current.hand == nextPlayerHand)) {
                return new Position(player, currentPlayerHand);
            } else {
                return current;
            }
        }
    }

    private static class First extends Move {
        private First(int number, int player) {
            super(number, player);
        }

        @Override
        Position apply(Position current) {
            if (current.player != player) {
                return current;
            } else {
                return new Position(player, current.hand == 'L' ? 'R' : 'L');
            }
        }
    }

    private static abstract class Move {
        final int number;
        final int player;

        private Move(int number, int player) {
            this.number = number;
            this.player = player;
        }

        abstract Position apply(Position current);
    }

    private record Position(int player, char hand) {
        @Override
        public String toString() {
            return player + " " + hand;
        }
    }

    private record IO(Position initialPosition, Move[] moves) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            int n = SCANNER.nextInt();

            Position initialPosition = new Position(SCANNER.nextInt(), SCANNER.next().charAt(0));

            Move[] moves = new Move[n];
            for (int i = 0; i < n; i++) {
                int moveNumber = SCANNER.nextInt();

                moves[i] = moveNumber == 1 ?
                        new First(1, SCANNER.nextInt()) :
                        new Second(2, SCANNER.nextInt(), SCANNER.next().charAt(0), SCANNER.next().charAt(0));
            }

            SCANNER.close();

            return new IO(initialPosition, moves);
        }

        static void output(Object output) {
            System.out.println(output);
        }
    }
}