import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/140039

*/

public class ModaresaneSharif {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(usualAnswer(input.question));
    }

    private static String usualAnswer(String question) {
        return "quera!";
    }

    private record IO(String question) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            if (SCANNER.hasNextLine()) {
                return new IO(SCANNER.nextLine());
            } else {
                return new IO(null);
            }
        }

        static void output(Object output) {
            System.out.println(output);
        }
    }
}