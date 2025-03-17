import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/102261

*/

public class RaminVaMasaleRiazi {
    public static void main(String[] args) {
        Input.getInput();
    }

    private static int countPerfectSquareNumbers(int l, int r) {
        return (int) (Math.floor(Math.sqrt(r)) - Math.ceil(Math.sqrt(l)) + 1);
    }

    private record Input() {
        private static final Scanner SCANNER = new Scanner(System.in);

        static void getInput() {
            getNumberRange(SCANNER.nextInt());
        }

        private static void getNumberRange(int q) {
            int l = 0;
            int r = 0;

            for (int i = 0; i < q; i++) {
                l = SCANNER.nextInt();
                r = SCANNER.nextInt();

                System.out.println(countPerfectSquareNumbers(l, r));
            }
        }
    }
}