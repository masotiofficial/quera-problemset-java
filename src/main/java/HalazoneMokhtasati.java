import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/597

*/

public class HalazoneMokhtasati {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(findCoordinates(input.n));
    }

    private static Coordinates findCoordinates(int n) {
        return switch (n % 4) {
            case 0 -> new Coordinates((int) (-n / 4.0), (int) (n / 4.0));
            case 1 -> new Coordinates((int) (-n / 4.0 + 1 / 4.0), (int) (-n / 4.0 + 1 / 4.0));
            case 2 -> new Coordinates((int) (n / 4.0 + 2 / 4.0), (int) (-n / 4.0 + 2 / 4.0));
            case 3 -> new Coordinates((int) (n / 4.0 + 1 / 4.0), (int) (n / 4.0 + 1 / 4.0));
            default -> throw new AssertionError();
        };
    }

    private record Coordinates(int x, int y) {
        @Override
        public String toString() {
            return x + " " + y;
        }
    }

    private record IO(int n) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            return new IO(SCANNER.nextInt());
        }

        static void output(Object output) {
            System.out.println(output);
        }
    }
}