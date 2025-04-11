import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/14581

*/

public class P0014581 {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(calculateAverageSoundPower(input.n()));
    }

    private static double calculateAverageSoundPower(long pagesCount) {
        if (pagesCount % 2 == 0) {
            return (double) ((2 * calculateSum(pagesCount / 2 - 1)) + (pagesCount / 2)) / (pagesCount + 1);
        } else {
            return (double) (2 * calculateSum(Math.floorDiv(pagesCount, 2))) / (pagesCount + 1);
        }
    }

    private static long calculateSum(long pagesCount) {
        return (pagesCount * (pagesCount + 1)) / 2;
    }

    private record IO(int n) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            return new IO(SCANNER.nextInt());
        }

        static void output(Object output) {
            System.out.println(output);
        }
    }
}