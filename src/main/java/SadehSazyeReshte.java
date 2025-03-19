import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/177665

*/

public class SadehSazyeReshte {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(simplify(input.string));
    }

    private static StringBuilder simplify(StringBuilder string) {
        for (int i = 0; i < string.length() - 1; i++) {
            char current = string.charAt(i);
            char next = string.charAt(i + 1);

            if (current == next) {
                string.delete(i, i + 2);

                i = i - 2;
                i = i <= -2 ? -1 : i;
            }
        }

        return string;
    }

    private record IO(int n, StringBuilder string) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            return new IO(Integer.parseInt(SCANNER.nextLine()), new StringBuilder(SCANNER.nextLine()));
        }

        static void output(Object output) {
            System.out.println(output);
        }
    }
}