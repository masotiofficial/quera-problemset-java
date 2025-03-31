import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/140035

*/

public class P0140035 {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(identifyTypeNumber(input.n));
    }

    private static String identifyTypeNumber(int number) {
        return isOdd(number) && isPrime(number) ? "zoj" : "fard";
    }

    private static boolean isOdd(int number) {
        return number % 2 != 0;
    }

    private static boolean isPrime(int number) {
        if (number == 1) return false;
        else if (number == 2) return true;
        else if (number == 3) return true;
        else if (number % 2 == 0) return false;
        else if (number % 3 == 0) return false;
        else
            for (int i = 5; i <= Math.sqrt(number); i++) {
                if (number % i == 0) return false;
            }

        return true;
    }

    private record IO(int n) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            return new IO(SCANNER.nextInt());
        }

        static void output(Object output) {
            System.out.println(output);
        }
    }
}