import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/140033

*/

public class P0140033 {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(countVowels(input.string));
    }

    private static int countVowels(String string) {
        return string.replaceAll("[^aeiou]", "").length();
    }

    private record IO(String string) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            return new IO(SCANNER.nextLine());
        }

        static void output(Object output) {
            System.out.println(output);
        }
    }
}