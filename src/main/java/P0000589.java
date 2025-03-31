import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/589

*/

public class P0000589 {
    public static void main(String[] args) {
        factorial();
    }

    private static void factorial() {
        System.out.println(computeP0000589(Input.getInput().n()));
    }

    private static int computeP0000589(int n) {
        int factorial = 1;

        for (int i = 2; i <= n; i++) {
            factorial *= i;
        }

        return factorial;
    }

    private record Input(int n) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static Input getInput() {
            return new Input(SCANNER.nextInt());
        }
    }
}

