import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/*

  Problem link: https://quera.org/problemset/2794

*/

public class P0002794 {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(findCoordinatesRectangle(input.coordinates));
    }

    private static Coordinate findCoordinatesRectangle(Coordinate[] coordinates) {
        Coordinate result;

        Map<Integer, Long> xCounts = Arrays.stream(coordinates)
                .mapToInt(coordinate -> coordinate.x)
                .boxed()
                .collect(Collectors.groupingBy(x -> x, Collectors.counting()));

        Map<Integer, Long> yCounts = Arrays.stream(coordinates)
                .mapToInt(coordinate -> coordinate.y)
                .boxed()
                .collect(Collectors.groupingBy(y -> y, Collectors.counting()));

        result = new Coordinate(
                xCounts.entrySet().stream()
                        .filter(entry -> entry.getValue() != 2)
                        .findFirst()
                        .orElseThrow()
                        .getKey(),
                yCounts.entrySet().stream()
                        .filter(entry -> entry.getValue() != 2)
                        .findFirst()
                        .orElseThrow()
                        .getKey()
        );

        return result;
    }

    private record Coordinate(int x, int y) {
        @Override
        public String toString() {
            return x + " " + y;
        }
    }

    private record IO(Coordinate[] coordinates) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            Coordinate[] coordinates = new Coordinate[3];

            for (int i = 0; i < 3; i++) {
                coordinates[i] = new Coordinate(SCANNER.nextInt(), SCANNER.nextInt());
            }

            return new IO(coordinates);
        }

        static void output(Object output) {
            System.out.print(output);
        }
    }
}