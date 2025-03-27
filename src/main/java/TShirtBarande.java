import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/3107

*/

public class TShirtBarande {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(itSuitable(input.shirtWidth, input.shirtLength, input.winnerWidth, input.winnerLength) ? "yes" : "no");
    }

    private static boolean itSuitable(int shirtWidth, int shirtLength, int winnerWidth, int winnerLength) {
        return (winnerWidth <= shirtWidth) && (winnerLength <= shirtLength);
    }

    private record IO(int shirtWidth, int shirtLength, int winnerWidth, int winnerLength) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            return new IO(SCANNER.nextInt(), SCANNER.nextInt(), SCANNER.nextInt(), SCANNER.nextInt());
        }

        static void output(Object output) {
            System.out.println(output);
        }
    }
}