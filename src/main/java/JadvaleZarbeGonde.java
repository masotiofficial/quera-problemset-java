import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/3409

*/

public class JadvaleZarbeGonde {
    public static void main(String[] args) {
        printMultiplicationTable();
    }

    private static void printMultiplicationTable() {
        System.out.println(buildMultiplicationTable(Input.getInput().n()));
    }

    private static StringBuilder buildMultiplicationTable(int n) {
        StringBuilder multiplicationTable = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                multiplicationTable.append(i * j).append(' ');
            }

            multiplicationTable.append("\n");
        }

        return multiplicationTable;
    }

    private record Input(int n) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static Input getInput() {
            return new Input(SCANNER.nextInt());
        }
    }
}

