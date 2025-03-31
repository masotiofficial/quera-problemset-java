import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/141570

*/

public class P0141570 {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(identifyArea(input.p));
    }

    private static String identifyArea(int score) {
        if (score <= 0) {
            return "out";
        } else if (score < 7) {
            return "white";
        } else {
            return "black";
        }
    }

    private record IO(int p) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            return new IO(SCANNER.nextInt());
        }

        static void output(Object output) {
            System.out.println(output);
        }
    }
}