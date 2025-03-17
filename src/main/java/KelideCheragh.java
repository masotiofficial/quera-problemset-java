import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/49028

*/

public class KelideCheragh {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO.input();
    }

    private record IO(int[] numbers) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static void input() {
            int n = SCANNER.nextInt();

            int before = 0;
            int current;
            int count = 0;
            for (int i = 0; i < n; i++) {
                current = SCANNER.nextInt();

                if (i > 0) {
                    count += before != current ? 1 : 0;
                }

                before = current;
            }

            IO.output(count);
        }

        static void output(Object output) {
            System.out.println(output);
        }
    }
}