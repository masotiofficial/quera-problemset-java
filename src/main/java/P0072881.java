import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/72881

*/

public class P0072881 {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(isEnough(input.n, input.k, input.s) ? "Kafie!" : "Na! yeki bayad bere sabzi bekhare");
    }

    private static boolean isEnough(int soupCount, double vegetablesPerSoup, double availableVegetables) {
        return availableVegetables >= soupCount * vegetablesPerSoup;
    }

    private record IO(int n, double k, double s) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            return new IO(SCANNER.nextInt(), SCANNER.nextDouble(), SCANNER.nextDouble());
        }

        static void output(Object output) {
            System.out.println(output);
        }
    }
}