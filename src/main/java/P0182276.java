import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/182276

*/

public class P0182276 {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(isPriority(input.location) ? "YES" : "NO");
    }

    private static boolean isPriority(String location) {
        return location.equals("EAST");
    }

    private record IO(String location) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            return new IO(SCANNER.nextLine());
        }

        static void output(Object output) {
            System.out.println(output);
        }
    }
}