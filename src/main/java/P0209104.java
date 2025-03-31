import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/209104

*/

public class P0209104 {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(determineTitle(input.trips));
    }

    private static String determineTitle(String trips) {
        if (trips.charAt(0) == 'Y') {
            return "Haji";
        } else if (trips.charAt(1) == 'Y') {
            return "Karbalaee";
        } else if (trips.charAt(2) == 'Y') {
            return "Mashti";
        } else {
            return "Agha";
        }
    }

    private record IO(String trips) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            return new IO(SCANNER.nextLine());
        }

        static void output(Object output) {
            System.out.print(output);
        }
    }
}