import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

/*

  Problem link: https://quera.org/problemset/221462

*/

public class P0221462 {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(input.cuboid().findUnknownCoordinate());
    }

    private record Cuboid(Coordinate[] vertices) {
        private Coordinate findUnknownCoordinate() {
            int missingX = findMissingAxisValue(extractAxisValues(Coordinate::x));
            int missingY = findMissingAxisValue(extractAxisValues(Coordinate::y));
            int missingZ = findMissingAxisValue(extractAxisValues(Coordinate::z));

            return new Coordinate(missingX, missingY, missingZ);
        }

        private int[] extractAxisValues(ToIntFunction<Coordinate> axisExtractor) {
            return Arrays.stream(vertices)
                    .mapToInt(axisExtractor)
                    .toArray();
        }

        private int findMissingAxisValue(int[] axisValues) {
            Map<Integer, Long> valueCounts = Arrays.stream(axisValues)
                    .boxed()
                    .collect(Collectors.groupingBy(x -> x, Collectors.counting()));

            return valueCounts.entrySet().stream()
                    .filter(entry -> entry.getValue() == 3)
                    .findFirst()
                    .map(Map.Entry::getKey)
                    .orElseThrow(() -> new IllegalStateException("No axis value appears exactly 3 times"));
        }
    }

    private record Coordinate(int x, int y, int z) {
        @Override
        public String toString() {
            return String.format("%d %d %d", x, y, z);
        }
    }

    private record IO(Cuboid cuboid) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            Coordinate[] vertices = new Coordinate[7];

            for (int i = 0; i < vertices.length; i++) {
                int x = SCANNER.nextInt();
                int y = SCANNER.nextInt();
                int z = SCANNER.nextInt();

                vertices[i] = new Coordinate(x, y, z);
            }

            return new IO(new Cuboid(vertices));
        }

        static void output(Object output) {
            System.out.print(output);
        }
    }
}