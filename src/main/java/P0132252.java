import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/132252

*/

public class P0132252 {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(calculateDimensions(input.R, input.B));
    }

    private static Dimensions calculateDimensions(int blackBlocks, int yellowBlocks) {
        Dimensions result = null;

        int area = blackBlocks + yellowBlocks;

        for (int i = 1; i <= Math.sqrt(area); i++) {
            if (area % i == 0) {
                int width = area / i;
                int height = i;

                if ((width - 2) * (height - 2) == yellowBlocks) {
                    result = new Dimensions(width, height);

                    break;
                }
            }
        }

        return result;
    }

    private record Dimensions(int width, int height) {
        @Override
        public String toString() {
            return width + " " + height;
        }
    }

    private record IO(int R, int B) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            return new IO(SCANNER.nextInt(), SCANNER.nextInt());
        }

        static void output(Object output) {
            System.out.println(output);
        }
    }
}