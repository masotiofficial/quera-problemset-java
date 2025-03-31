import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/*

  Problem link: https://quera.org/problemset/649

*/

public class P0000649 {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(findPrimeNumbers(input.a, input.b).stream()
                .map(String::valueOf)
                .collect(Collectors.joining(","))
        );
    }

    private static List<Integer> findPrimeNumbers(int start, int end) {
        List<Integer> result = new ArrayList<>();

        for (int i = start + 1; i < end; i++) {
            if (isPrime(i)) {
                result.add(i);
            }
        }

        return result;
    }

    private static boolean isPrime(int number) {
        if (number == 1) return false;
        else if (number == 2) return true;
        else if (number == 3) return true;
        else if (number % 2 == 0) return false;
        else if (number % 3 == 0) return false;
        else {
            for (int i = 5; i * i <= number; i += 6) {
                if ((number % i == 0) || (number % (i + 2) == 0)) return false;
            }

            return true;
        }
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