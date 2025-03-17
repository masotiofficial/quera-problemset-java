import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/72876

*/

public class GholBanoVaDoGholoHayash {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(reverse(input.name));
    }

    private static String reverse(String name) {
       return new StringBuilder(name).reverse().toString();
    }

    private record IO(String name) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            return new IO(SCANNER.nextLine());
        }

        static void output(Object output) {
            System.out.print(output);
        }
    }
}