import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/244102

*/

public class P0244102 {
    public static void main(String[] args) {
        findMinimumNumberDays();
    }

    private static void findMinimumNumberDays() {
        Input input = Input.getInput();

        System.out.print(buildShortestPathGraphAdjacencyMatrix(input.c - 1, input.r - 1));
    }

    private static int buildShortestPathGraphAdjacencyMatrix(int column, int row) {
        final int[][] ADJACENCY_MATRIX = {
                {1, 1, 1, 1, 2, 2, 2},
                {1, 1, 1, 1, 1, 1, 2},
                {1, 1, 1, 1, 2, 1, 1},
                {1, 1, 1, 1, 1, 1, 1},
                {2, 1, 2, 1, 1, 1, 2},
                {2, 1, 1, 1, 1, 1, 1},
                {2, 2, 1, 1, 2, 1, 1}
        };

        return ADJACENCY_MATRIX[column][row];
    }

    private record Input(int c, int r) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static Input getInput() {
            return new Input(SCANNER.nextInt(), SCANNER.nextInt());
        }
    }
}