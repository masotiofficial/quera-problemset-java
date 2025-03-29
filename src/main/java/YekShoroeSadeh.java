import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*

  Problem link: https://quera.org/problemset/9719

*/

public class YekShoroeSadeh {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(findPalindromeSquares(input.b).entrySet().stream()
                .map(entry -> entry.getKey() + " " + entry.getValue())
                .collect(Collectors.joining("\n"))
        );
    }

    private static Map<String, String> findPalindromeSquares(int base) {
        Map<String, String> result = new LinkedHashMap<>();

        for (int i = 1; i <= 300; i++) {
            String squareInBase = convertBase(i * i, base);

            if (isPalindrome(squareInBase)) {
                result.put(convertBase(i, base), squareInBase);
            }
        }

        return result;
    }

    private static boolean isPalindrome(String number) {
        return IntStream.range(0, number.length() / 2)
                .allMatch(i -> number.charAt(i) == number.charAt(number.length() - 1 - i));
    }

    private static String convertBase(int number, int radix) {
        return Integer.toUnsignedString(number, radix).toUpperCase();
    }

    private record IO(int b) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            return new IO(SCANNER.nextInt());
        }

        static void output(Object output) {
            System.out.println(output);
        }
    }
}