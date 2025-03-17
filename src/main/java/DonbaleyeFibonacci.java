import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/303

*/

public class DonbaleyeFibonacci {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        fibonacci(input.a, input.b).forEach(IO::output);
    }

    private static List<Integer> fibonacci(int a, int b) {
        List<Integer> fibonacciNumbers = new ArrayList<>();

        int temp;
        while (b != 1) {
            fibonacciNumbers.add(a);

            temp = a;
            a = b - a;
            b = temp;
        }
        fibonacciNumbers.add(b);

        return fibonacciNumbers;
    }

    private record IO(int a, int b) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            return new IO(SCANNER.nextInt(), SCANNER.nextInt());
        }

        static void output(Object output) {
            System.out.println(output);
        }
    }
}