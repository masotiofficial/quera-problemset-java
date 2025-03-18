import java.util.*;
import java.util.stream.Collectors;

/*

  Problem link: https://quera.org/problemset/6193

*/

public class MasaleyeAmniati {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(encrypt(input.s));
    }

    private static String encrypt(String text) {
        StringBuilder encrypted = new StringBuilder();

        Map<Character, Long> letterCounts = text.toLowerCase()
                .chars()
                .mapToObj(ch -> (char) ch)
                .collect(Collectors.groupingBy(ch -> ch, Collectors.counting()));

        for (char originalChar : text.toCharArray()) {
            char lowerChar = Character.toLowerCase(originalChar);
            long repetition = letterCounts.get(lowerChar);

            int basePosition = lowerChar - 'a';
            long shift = repetition * basePosition + 1;
            int newPosition = (int) (shift % 26);
            char newChar = (char) (newPosition + 'a');

            char resultChar = Character.isUpperCase(originalChar)
                    ? Character.toUpperCase(newChar)
                    : newChar;

            encrypted.append(resultChar);
        }

        return encrypted.toString();
    }

    private record IO(String s) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            return new IO(SCANNER.nextLine());
        }

        static void output(Object output) {
            System.out.println(output);
        }
    }
}