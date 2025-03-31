import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/282

*/

public class P0000282 {
    public static void main(String[] args) {
        isPerfectNumber();
    }

    private static void isPerfectNumber() {
        int n = Input.getInput().n();

        System.out.println(sumOfDivisors(n) == n ? "YES" : "NO");
    }

    private static int sumOfDivisors(int n) {
        int sum = 0;

        for (int i = 1; i <= n / 2; i++) {
            if (n % i == 0) {
                sum += i;
            }
        }

        return sum;
    }

    private record Input(int n) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static Input getInput() {
            return new Input(SCANNER.nextInt());
        }
    }
}

