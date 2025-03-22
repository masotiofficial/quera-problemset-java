import java.util.Arrays;
import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/104588

*/

public class Nobaraneh {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(determineState(input.a));
    }

    private static String determineState(int[] watermelons) {
        long count = countGoodWatermelons(watermelons);

        if(count >= 3) {
            return "Mamma mia!";
        } else if ((count == 1) || (count == 2)) {
            return "Mamma mia!!";
        } else {
            return "Mamma mia!!!";
        }
    }

    private static long countGoodWatermelons(int[] watermelons) {
        return Arrays.stream(watermelons)
                .filter(watermelon -> watermelon >= 80)
                .count();
    }

    private record IO(int[] a) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            int[] a = new int[5];
            for (int i = 0; i < 5; i++) {
                a[i] = SCANNER.nextInt();
            }

            return new IO(a);
        }

        static void output(Object output) {
            System.out.print(output);
        }
    }
}