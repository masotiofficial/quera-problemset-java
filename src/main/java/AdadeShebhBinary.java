import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/176775

*/

public class AdadeShebhBinary {
    public static void main(String[] args) {
        isPseudoBinaryNumber();
    }

    private static void isPseudoBinaryNumber() {
        int sumOfDivisors = sumOfDivisors(Input.getInput().n);

        if (sumOfDivisors == 0) {
            System.out.println(0);
        } else {
            System.out.println((sumOfDivisors & (sumOfDivisors - 1)) == 0 ? 1 : 0);
        }
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

