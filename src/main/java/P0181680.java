import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/181680

*/

public class P0181680 {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(calculateRestTime(input.w(), input.s(), input.i()));
    }

    private static int calculateRestTime(int workTime, int studiesTime, int overlap) {
        return 24 - (workTime + studiesTime - overlap);
    }

    private record IO(int w, int s, int i) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            return new IO(SCANNER.nextInt(), SCANNER.nextInt(), SCANNER.nextInt());
        }

        static void output(Object output) {
            System.out.println(output);
        }
    }
}