import java.util.Arrays;
import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/235094

*/

public class P0235094 {
    public static void main(String[] args) {
        Input.getInput();
    }

    private record Input() {
        private static final Scanner SCANNER = new Scanner(System.in);

        static void getInput() {
            int n = SCANNER.nextInt();

            int[] intimacy = new int[n];
            for (int i = 0; i < n; i++) {
                intimacy[i] = SCANNER.nextInt();
            }

            Arrays.sort(intimacy);

            System.out.println(intimacy[n - 1]);
        }
    }
}