import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/599

*/

public class P0000599 {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(new ProjectileRange(input.Vx(), input.Vy(), input.Yz(), input.h()).calculate());
    }

    private record ProjectileRange(double Vx, double Vy, double Yz, double h) {
        private Answer calculate() {
            QuadraticEquation.Answer quadraticEquationAnswer = new QuadraticEquation(-10.0 / 2.0, Vy, Yz - h).solve();

            if (quadraticEquationAnswer == null) {
                return new Answer(null, null);
            } else {
                double min = Math.min(quadraticEquationAnswer.firstRoot(), quadraticEquationAnswer.secondRoot());
                double max = Math.max(quadraticEquationAnswer.firstRoot(), quadraticEquationAnswer.secondRoot());

                if ((min < 0) && (max < 0)) {
                    return new Answer(null, null);
                } else if (min < 0) {
                    return new Answer(null, max * Vx);
                } else if (max < 0) {
                    return new Answer(min * Vx, null);
                } else {
                    return new Answer(min * Vx, max * Vx);
                }
            }
        }

        private record Answer(Double first, Double second) {
            @Override
            public String toString() {
                if ((first == null) && (second == null)) {
                    return "impossible";
                } else if (first == null) {
                    return String.format("%.2f", second);
                } else if (second == null) {
                    return String.format("%.2f", first);
                } else if (first.equals(second)) {
                    return String.format("%.2f", first);
                } else {
                    double min = Math.min(first, second);
                    double max = Math.max(first, second);

                    return String.format("%.2f\n%.2f", min, max);
                }
            }
        }
    }

    private record QuadraticEquation(double a, double b, double c) {
        private Answer solve() {
            double delta = b * b - 4 * a * c;

            if (delta < 0) {
                return null;
            } else {
                delta = Math.sqrt(delta);

                double firstRoot = (-b - delta) / (2 * a);
                double secondRoot = (-b + delta) / (2 * a);

                return new Answer(firstRoot, secondRoot);
            }
        }

        private record Answer(double firstRoot, double secondRoot) {
        }
    }

    private record IO(double Vx, double Vy, double Yz, double h) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            return new IO(SCANNER.nextDouble(), SCANNER.nextDouble(), SCANNER.nextDouble(), SCANNER.nextDouble());
        }

        static void output(Object output) {
            System.out.println(output);
        }
    }
}