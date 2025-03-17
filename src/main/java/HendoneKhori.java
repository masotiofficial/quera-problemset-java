import java.util.*;

/*

  Problem link: https://quera.org/problemset/35253

*/

public class HendoneKhori {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(lastWatermelon(input.n, input.watermelons).number);
    }

    private static Watermelon lastWatermelon(int n, Watermelon[] watermelons) {
        Watermelon result = watermelons[0];

        for (int i = 0; i < n - 1; i++) {
            result = result.compareTo(watermelons[i]) > 0 ? result : watermelons[i];
        }

        return result;
    }

    private record Watermelon(int number, int weight) implements Comparable<Watermelon> {
        @Override
        public int compareTo(Watermelon o) {
            return weight - o.weight;
        }
    }

    private record IO(int n, Watermelon[] watermelons) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            int n = SCANNER.nextInt();

            Watermelon[] watermelons = new Watermelon[n];
            for (int i = 0; i < n; i++) {
                watermelons[i] = new Watermelon(i + 1, SCANNER.nextInt());
            }

            return new IO(n, watermelons);
        }

        static void output(Object output) {
            System.out.print(output);
        }
    }
}