import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/232026

*/

public class P0232026 {
    public static void main(String[] args) {
        Input.getInput();
    }

    private static int sequence(int n) {
        if (n == 1) {
            return 2;
        } else {
            return switch (n % 4) {
                case 0 -> 2;
                case 1 -> -2;
                case 2 -> 1;
                case 3 -> -3;
                default -> 0;
            };
        }
    }

    private record Input() {
        private static final Scanner SCANNER = new Scanner(System.in);

        static void getInput() {
            getN(SCANNER.nextInt());
        }

        private static void getN(int t) {
            for (int i = 0; i < t; i++) {
                System.out.println(sequence(SCANNER.nextInt()));
            }
        }
    }
}