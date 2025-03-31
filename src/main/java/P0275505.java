import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/275505

*/

public class P0275505 {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(countFreeCourses(input.n));
    }

    private static int countFreeCourses(int referrals) {
        return referrals / 10;
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