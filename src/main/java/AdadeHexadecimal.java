import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/277

*/

public class AdadeHexadecimal {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(countBinaryNumbers(input.n));
    }

    private static int countBinaryNumbers(int n) {
        int result = 0;

        Queue<String> binaryNumbers = new LinkedList<>();
        binaryNumbers.add("1");
        while (!binaryNumbers.isEmpty()) {
            int number = Integer.parseInt(binaryNumbers.poll());

            if (number <= n) {
                result++;
            } else {
                break;
            }

            binaryNumbers.add(number + "0");
            binaryNumbers.add(number + "1");
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