import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/33045

*/

public class MaghsomonElaihHayeDardesarSaz {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(solve(input.n));
    }

    private static String solve(int n) {
        int count = 0;
        long sum = 0;

        for (int i = 1; i <= n; i++) {
            Divider divider = new Divider(i);

            count += divider.countDividers;
            sum += divider.sumOfDividers;
        }

        return count + " " + sum;
    }

    private static class Divider {
        final int number;
        int[] dividers;
        int countDividers;
        long sumOfDividers;


        private Divider(int number) {
            this.number = number;

            dividers = dividers(number);

            countDividers = dividers.length;
            sumOfDividers = Arrays.stream(dividers).sum();
        }

        private int[] dividers(int number) {
            List<Integer> dividers = new ArrayList<>();

            for (int i = 1; i <= Math.sqrt(number); i++) {
                int x = number / i;
                int y = number % i;

                if (y == 0) {
                    dividers.add(i);

                    if (x != i) {
                        dividers.add(x);
                    }
                }
            }

            return dividers.stream().mapToInt(i -> i).toArray();
        }
    }

    private record IO(int n) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            return new IO(SCANNER.nextInt());
        }

        static void output(Object output) {
            System.out.print(output);
        }
    }
}