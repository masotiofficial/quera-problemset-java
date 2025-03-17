import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/15124

*/

public class KhabePopak {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        List<Integer> dividersA = calculateDividers(input.a);
        List<Integer> dividersB = calculateDividers(input.b);

        System.out.println(countDreams(dividersA, dividersB, input.x));
    }

    private static int countDreams(List<Integer> dividersA, List<Integer> dividersB, int x) {
        int count = 0;

        for (int da : dividersA) {
            for (int db : dividersB) {
                if (da + db <= x) {
                    count++;
                }
            }
        }

        return count;
    }

    private static List<Integer> calculateDividers(int n) {
        List<Integer> divisors = new ArrayList<>();

        for (int i = 1; i <= n / 2; i++) {
            if (n % i == 0) {
                divisors.add(i);
            }
        }

        divisors.add(n);

        return divisors;
    }

    private record IO(int a, int b, int x) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            return new IO(SCANNER.nextInt(), SCANNER.nextInt(), SCANNER.nextInt());
        }

        static void output(Object output) {
            System.out.println(output);
        }
    }
}