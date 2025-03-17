import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/175188

*/

public class Tardasti {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO.input();
    }

    private static int minOperations(String cards) {
        int count = 0;

        boolean isBack = false;
        for (char card : cards.toCharArray()) {
            if ((card == '0') && (!isBack)) {
                count++;

                isBack = true;
            }

            if (card == '1') {
                isBack = false;
            }
        }

        return count;
    }

    private record IO() {
        private static final Scanner SCANNER = new Scanner(System.in);

        static void input() {
            int t = SCANNER.nextInt();
            SCANNER.nextLine();

            for (int i = 0; i < t; i++) {
                output(minOperations(SCANNER.nextLine()));
            }
        }

        static void output(Object output) {
            System.out.println(output);
        }
    }
}