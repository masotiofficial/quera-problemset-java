import java.util.Arrays;
import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/6082

*/

public class AsemaneShekarAbad {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(countStars(input.sky));
    }

    private static int countStars(String[][] sky) {
        return (int) Arrays.stream(sky)
                .flatMap(Arrays::stream)
                .filter(cell -> cell.equals("*"))
                .count();
    }

    private record IO(int n, int m, String[][] sky) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            int n = SCANNER.nextInt();
            int m = SCANNER.nextInt();
            SCANNER.nextLine();

            String[][] sky = new String[n][m];
            for (int i = 0; i < n; i++) {
                sky[i] = SCANNER.nextLine().split("");
            }

            return new IO(n, m, sky);
        }

        static void output(Object output) {
            System.out.println(output);
        }
    }
}