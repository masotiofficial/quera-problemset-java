import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/140029

*/

public class P0140029 {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(series(input.n));
    }

    private static long series(long number) {
        return number * (number + 1) / 2;
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