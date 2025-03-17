import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/2530

*/

public class Loknat {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(pronunciationTypes(input.word));
    }

    private static int pronunciationTypes(String word) {
        long k = word.chars()
                .filter(ch -> ch == 'T' || ch == 'D' || ch == 'L' || ch == 'F')
                .count();

        return (int) Math.pow(2, k);
    }

    private record IO(String word) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            return new IO(SCANNER.nextLine());
        }

        static void output(Object output) {
            System.out.print(output);
        }
    }
}