import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/275795

*/

public class P0275795 {
    public static void main(String[] args) {
        printSumSequence(Input.getInput().n);
    }

    private static void printSumSequence(int n) {
        System.out.println(buildSumSequence(n));
    }

    private static String buildSumSequence(int n) {
        StringBuilder sequence = new StringBuilder();
        int sum = calculateSum(n);

        for (int i = 1; i < n; i++) {
            sequence.append(i).append(" + ");
        }
        sequence.append(n).append(" = ").append(sum);

        return sequence.toString();
    }

    private static int calculateSum(int n) {
        return (n * (n + 1)) / 2;
    }

    private record Input(int n) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static Input getInput() {
            return new Input(SCANNER.nextInt());
        }
    }
}