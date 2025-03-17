import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/294

*/

public class MoadeleDarajeDo {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(solve(input.a, input.b, input.c));
    }


    private static String solve(double a, double b, double c) {
        if (delta(a, b, c) < 0) {
            return "IMPOSSIBLE";
        } else if ((a == 0) && (b == 0)) {
            return "IMPOSSIBLE";
        } else if (a == 0) {
            return String.format("%.3f", -c / b);
        } else {
            double rootOne = rootOne(a, b, c);
            double rootTwo = rootTwo(a, b, c);

            if (rootOne == rootTwo) {
                return String.format("%.3f", rootOne);
            } else {
                return String.format("%.3f%n%.3f", Math.min(rootOne, rootTwo), Math.max(rootOne, rootTwo));
            }
        }
    }

    private static double rootOne(double a, double b, double c) {
        return (-b + sqrtDelta(a, b, c)) / (2 * a);
    }

    private static double rootTwo(double a, double b, double c) {
        return (-b - sqrtDelta(a, b, c)) / (2 * a);
    }


    private static double sqrtDelta(double a, double b, double c) {
        return Math.sqrt(delta(a, b, c));
    }

    private static double delta(double a, double b, double c) {
        return (b * b) - (4 * a * c);
    }

    private record IO(double a, double b, double c) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            return new IO(SCANNER.nextDouble(), SCANNER.nextDouble(), SCANNER.nextDouble());
        }

        static void output(Object output) {
            System.out.println(output);
        }
    }
}