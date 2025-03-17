import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/168941

*/

public class CosmicTwins {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(String.format("%.6f", 1 - birthdayProblem(input.P, input.D)));
    }

    private static double birthdayProblem(int P, int D) {
        BigDecimal probability = BigDecimal.ONE;

        for (int i = 0; i < P; i++) {
            probability = probability.multiply(BigDecimal.valueOf(D - i));
        }

        return probability.divide(BigDecimal.valueOf(D).pow(P), 6, RoundingMode.HALF_UP).doubleValue();
    }

    private record IO(int P, int D) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            return new IO(SCANNER.nextInt(), SCANNER.nextInt());
        }

        static void output(Object output) {
            System.out.println(output);
        }
    }
}