import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/35254

*/

public class P0035254 {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(minOperations(input.n, input.homes, input.s, input.t));
    }

    private static int minOperations(int n, String homes, int s, int t) {
        int result = 0;

        int start = Math.min(s, t) - 1;
        int end = Math.max(s, t) - 1;
        String operationRange = start + 1 >= end ? "" : homes.substring(start + 1, end);

        int count = 0;
        for (int i = 0; i < operationRange.length(); i++) {
            char home = operationRange.charAt(i);

            if (home == 'H') {
                count++;
            }
            if (((home == 'P') || (i == operationRange.length() - 1)) && (count != 0)) {
                result += countOperations(count, 0);

                count = 0;
            }
        }

        return result;
    }

    private static int countOperations(int count, int operations) {
        if (count == 0) {
            return operations;
        } else {
            operations++;
            return countOperations((int) (count - Math.pow(2, Math.floor(Math.log10(count) / Math.log10(2)))), operations);
        }
    }

    private record IO(int n, String homes, int s, int t) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            return new IO(Integer.parseInt(SCANNER.nextLine()), SCANNER.nextLine(), SCANNER.nextInt(), SCANNER.nextInt());
        }

        static void output(Object output) {
            System.out.println(output);
        }
    }
}