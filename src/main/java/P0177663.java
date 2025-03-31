import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/177663

*/

public class P0177663 {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        List<List<Integer>> combinations = combinations(input.numbers, 4);

        int divisible = 0;
        int dividers;
        for (List<Integer> combination : combinations) {
            dividers = countDivisors(input.n, lcm(combination));

            if (combination.size() % 2 == 0) {
                divisible -= dividers;
            } else {
                divisible += dividers;
            }
        }

        IO.output(divisible);
    }

    private static int countDivisors(int n, int number) {
        return n / number;
    }

    private static int lcm(List<Integer> numbers) {
        int result = 1;

        for (int num : numbers) {
            result = lcm(result, num);
        }

        return result;
    }

    private static int lcm(int a, int b) {
        return a * (b / gcd(a, b));
    }

    private static int gcd(int a, int b) {
        int temp;

        while (b != 0) {
            temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }

    public static List<List<Integer>> combinations(int[] numbers, int k) {
        List<List<Integer>> result = new ArrayList<>();

        for (int length = 1; length <= k; length++) {
            combinationsHelper(numbers, length, 0, new ArrayList<>(), result);
        }

        return result;
    }

    private static void combinationsHelper(int[] numbers, int length, int start, List<Integer> current, List<List<Integer>> result) {
        if (current.size() == length) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < numbers.length; i++) {
            current.add(numbers[i]);
            combinationsHelper(numbers, length, i + 1, current, result);
            current.remove(current.size() - 1);
        }
    }

    private record IO(int n, int[] numbers) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            int n = SCANNER.nextInt();

            int[] numbers = new int[4];
            for (int i = 0; i < 4; i++) {
                numbers[i] = SCANNER.nextInt();
            }

            return new IO(n, numbers);
        }

        static void output(Object output) {
            System.out.println(output);
        }
    }
}