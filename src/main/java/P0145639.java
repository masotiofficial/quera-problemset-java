import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/145639

*/

public class P0145639 {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(responseTime(input.s, input.f, input.l, input.x));
    }

    private static String responseTime(int s, int f, int l, int x) {
       if(x < s) {
           return "exam did not started!";
       } else if(x >= f) {
           return "exam finished!";
       } else {
           return String.valueOf(Math.min(l, f - x));
       }
    }

    private record IO(int s, int f, int l, int x) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            return new IO(SCANNER.nextInt(), SCANNER.nextInt(), SCANNER.nextInt(), SCANNER.nextInt());
        }

        static void output(Object output) {
            System.out.println(output);
        }
    }
}