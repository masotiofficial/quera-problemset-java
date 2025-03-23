import java.util.*;

/*

  Problem link: https://quera.org/problemset/602

*/

public class KashfeMoadele {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        findMatchingEquations(input.n, input.coordinates).forEach(IO::output);
    }

    private static List<String> findMatchingEquations(int n, Coordinates[] coordinates) {
        List<String> result = new ArrayList<>();

        int fractionalPartCount = (int) Arrays.stream(coordinates)
                .filter(coordinate -> isFractionalPart(coordinate.x, coordinate.y))
                .count();

        int quadraticCount = (int) Arrays.stream(coordinates)
                .filter(coordinate -> isQuadratic(coordinate.x, coordinate.y))
                .count();

        int cubicWithAbsoluteCount = (int) Arrays.stream(coordinates)
                .filter(coordinate -> isCubicWithAbsolute(coordinate.x, coordinate.y))
                .count();

        if (fractionalPartCount == n) result.add("1");

        if (quadraticCount == n) result.add("2");

        if (cubicWithAbsoluteCount == n) result.add("3");

        if (result.isEmpty()) result.add("No ones");

        return result;
    }

    private static boolean isFractionalPart(double x, double y) {
        return Math.abs(y - (x - Math.floor(x))) <= 0.2;
    }

    private static boolean isQuadratic(double x, double y) {
        return Math.abs(y - (x * x + x)) <= 0.2;
    }

    private static boolean isCubicWithAbsolute(double x, double y) {
        return Math.abs(y - (Math.abs(-x * x * x + 1) + x * x * x)) <= 0.2;
    }

    private record Coordinates(double x, double y) {
    }

    private record IO(int n, Coordinates[] coordinates) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            int n = SCANNER.nextInt();

            Coordinates[] coordinates = new Coordinates[n];
            for (int i = 0; i < n; i++) {
                coordinates[i] = new Coordinates(SCANNER.nextDouble(), SCANNER.nextDouble());
            }

            return new IO(n, coordinates);
        }

        static void output(Object output) {
            System.out.println(output);
        }
    }
}