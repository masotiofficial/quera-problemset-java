import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/178600

*/

public class P0178600 {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(measureEffectiveness(input.n, input.k, input.p, input.q));
    }

    private static String measureEffectiveness(int n, int k, int p, int q) {
        int shekarestanRecovered = n - k;
        int namakestanRecovered = p - q;

        if (shekarestanRecovered > namakestanRecovered) {
            return "Shekarestan";
        } else if (shekarestanRecovered < namakestanRecovered) {
            return "Namakestan";
        } else {
            return "Equal";
        }
    }

    private record IO(int n, int k, int p, int q) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            return new IO(SCANNER.nextInt(), SCANNER.nextInt(), SCANNER.nextInt(), SCANNER.nextInt());
        }

        static void output(Object output) {
            System.out.println(output);
        }
    }
}