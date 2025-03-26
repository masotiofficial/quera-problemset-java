import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/275111

*/

public class LostInDesert {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(findPosition(input.locations));
    }

    private static String findPosition(String locations) {
        String[] tokens = locations.split(" ");

        if (tokens[0].equals(tokens[2])) {
            return "together";
        } else {
            return "lost";
        }
    }

    private record IO(String locations) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            return new IO(SCANNER.nextLine());
        }

        static void output(Object output) {
            System.out.println(output);
        }
    }
}