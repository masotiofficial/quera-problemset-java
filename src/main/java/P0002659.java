import java.util.Scanner;
import java.util.stream.IntStream;

/*

  Problem link: https://quera.org/problemset/2659

*/

public class P0002659 {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(countMistakes(input.n, input.mainWord, input.writtenWord));
    }

    private static int countMistakes(int length, String mainWord, String writtenWord) {
        return (int) IntStream.range(0, length)
                .filter(i -> mainWord.charAt(i) != writtenWord.charAt(i))
                .count();
    }

    private record IO(int n, String mainWord, String writtenWord) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            return new IO(Integer.parseInt(SCANNER.nextLine()), SCANNER.nextLine(), SCANNER.nextLine());
        }

        static void output(Object output) {
            System.out.println(output);
        }
    }
}