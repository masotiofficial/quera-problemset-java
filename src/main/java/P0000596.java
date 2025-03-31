import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/596

*/

public class P0000596 {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(String.join(" ", expressAsFibonacci(input.n())));
    }

    private static List<String> expressAsFibonacci(int number) {
        List<String> result = new ArrayList<>();

        List<Integer> fibonacciSeries = fibonacciSeries(number);

        for (int i = fibonacciSeries.size() - 1; number != 0; i--) {
            if (fibonacciSeries.get(i) <= number) {
                number -= fibonacciSeries.get(i);

                result.add(String.valueOf(i + 1));
            }
        }

        return result;
    }

    private static List<Integer> fibonacciSeries(int number) {
        List<Integer> result = new ArrayList<>();
        result.add(1);
        result.add(2);

        for (int i = 2; i < number; i++) {
            int nextFibonacci = result.get(i - 1) + result.get(i - 2);

            if (nextFibonacci <= number) {
                result.add(nextFibonacci);
            } else {
                break;
            }
        }

        return result;
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