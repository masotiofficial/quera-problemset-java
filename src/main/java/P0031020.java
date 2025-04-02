import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/31020

*/

public class P0031020 {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(maxStudentsThroughDoorOne(input.n(), input.m()));
    }

    private static int maxStudentsThroughDoorOne(int students, int doors) {
        return (int) Math.ceil((double) students / doors);
    }

    private record IO(int n, int m) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            return new IO(SCANNER.nextInt(), SCANNER.nextInt());
        }

        static void output(Object output) {
            System.out.print(output);
        }
    }
}