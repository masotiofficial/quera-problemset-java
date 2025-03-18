import java.util.*;

/*

  Problem link: https://quera.org/problemset/127289

*/

public class TekrareCodeCupy {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(charAt(input.n));
    }

    private static char charAt(int n) {
        return switch (n % 8) {
            case 0 -> '6';
            case 1, 5 -> 'c';
            case 2 -> 'o';
            case 3 -> 'd';
            case 4 -> 'e';
            case 6 -> 'u';
            case 7 -> 'p';
            default -> 0;
        };
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