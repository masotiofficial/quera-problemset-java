import java.util.Arrays;
import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/20249

*/

public class MorabaHaVaMoshkelateEghtesadi {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(maxAdditionalContainers(input.n, input.k, input.a));
    }

    private static int maxAdditionalContainers(int containersCount, double containerCapacity, int[] amounts) {
        long sum = Arrays.stream(amounts).sum();

        int minContainersNeeded = (int) Math.ceil(sum / containerCapacity);

        return Math.max(0, containersCount - minContainersNeeded);
    }

    private record IO(int n, int k, int[] a) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            int n = SCANNER.nextInt();
            int k = SCANNER.nextInt();

            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = SCANNER.nextInt();
            }

            return new IO(n, k, a);
        }

        static void output(Object output) {
            System.out.println(output);
        }
    }
}