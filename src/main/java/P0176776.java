import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/176776

*/

public class P0176776 {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(maxConsecutiveFans(input.fans));
    }

    private static int maxConsecutiveFans(String fans) {
        int maxCount = 0;
        int currentCount = 0;

        for (int i = 0; i < fans.length(); i++) {
            if (fans.charAt(i) == '0') {
                currentCount++;

                maxCount = Math.max(maxCount, currentCount);
            } else {
                currentCount = 0;
            }
        }

        return maxCount;
    }

    private record IO(String fans) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            return new IO(SCANNER.nextLine());
        }

        static void output(Object output) {
            System.out.println(output);
        }
    }
}