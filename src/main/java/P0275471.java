import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/275471

*/

public class P0275471 {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(countPiecesCake(input.n(), input.a(), input.b(), input.c(), input.d()));
    }

    private static int countPiecesCake(int n, int a, int b, int c, int d) {
        List<Integer> smallerRange = rangeOfSlice(n, Math.min(a,b), Math.max(a, b));
        List<Integer> largerRange = rangeOfSlice(n, Math.max(a,b), Math.min(a, b));

        boolean cInSmallerRange = smallerRange.contains(c);
        boolean dInSmallerRange = smallerRange.contains(d);

        boolean cInLargerRange = largerRange.contains(c);
        boolean dInLargerRange = largerRange.contains(d);

        if ((cInSmallerRange && dInSmallerRange) || (cInLargerRange && dInLargerRange)) {
            return 3;
        } else {
            return 4;
        }
    }

    private static List<Integer> rangeOfSlice(int length, int start, int end) {
        List<Integer> rangeOfSliceOne = new ArrayList<>();

        int i = start;
        while (true) {
            rangeOfSliceOne.add(i);

            if (i == end) break;

            i = (i % length) + 1;
        }

        return rangeOfSliceOne;
    }

    private record IO(int n, int a, int b, int c, int d) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            return new IO(SCANNER.nextInt(), SCANNER.nextInt(), SCANNER.nextInt(), SCANNER.nextInt(), SCANNER.nextInt());
        }

        static void output(Object output) {
            System.out.println(output);
        }
    }
}