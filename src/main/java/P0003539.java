import java.util.Arrays;
import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/3539

*/

public class P0003539 {
    public static void main(String[] args) {
        reduceToSingleDigit();
    }

    private static void reduceToSingleDigit() {
        String n = sumOfDigits(Input.getInput().n);

        while (n.length() != 1) {
            n = sumOfDigits(n);
        }

        System.out.println(n);
    }

    private static String sumOfDigits(String n) {
        return String.valueOf(Arrays.stream(n.split(""))
                .mapToInt(Integer::parseInt)
                .sum());
    }

    private record Input(String n) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static Input getInput() {
            return new Input(SCANNER.nextLine());
        }
    }
}