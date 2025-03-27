import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

/*

  Problem link: https://quera.org/problemset/4067

*/

public class Sarab {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(Arrays.stream(findTimes(input.coordinates))
                .mapToObj(String::valueOf)
                .collect(Collectors.joining("\n"))
        );
    }

    private static int[] findTimes(Coordinate[] coordinates) {
        int[] result = new int[coordinates.length];

        for (int i = 0; i < coordinates.length; i++) {
            Coordinate coordinate = coordinates[i];

            if (coordinate.x == coordinate.y) {
                result[i] = 2 * coordinate.x - (coordinate.x % 2 == 0 ? 0 : 1);
            } else if (coordinate.x - 2 == coordinate.y) {
                result[i] = 2 * coordinate.x - (coordinate.x % 2 == 0 ? 2 : 3);
            } else {
                result[i] = -1;
            }
        }

        return result;
    }

    private record Coordinate(int x, int y) {
    }

    private record IO(Coordinate[] coordinates) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            int t = SCANNER.nextInt();

            Coordinate[] coordinates = new Coordinate[t];
            for (int i = 0; i < t; i++) {
                coordinates[i] = new Coordinate(SCANNER.nextInt(), SCANNER.nextInt());
            }

            return new IO(coordinates);
        }

        static void output(Object output) {
            System.out.println(output);
        }
    }
}