import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

/*

  Problem link: https://quera.org/problemset/10326

*/

public class P0010326 {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(Arrays.stream(countChocolatesEaten(input.chocolates))
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" "))
        );
    }

    private static int[] countChocolatesEaten(int[] chocolates) {
        int[] result = new int[chocolates.length];

        int currentPart = 2;
        int currentPerson = -1;
        while (chocolates[currentPart] != 0) {
            currentPart = currentPart == 0 ? 2 : 0;
            currentPerson = (currentPerson + 1) % 4;

            chocolates[currentPart]--;
            result[currentPerson]++;
        }

        return result;
    }

    private record IO(int[] chocolates) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            int[] chocolates = new int[4];

            for (int i = 0; i < chocolates.length; i++) {
                chocolates[i] = SCANNER.nextInt();
            }

            return new IO(chocolates);
        }

        static void output(Object output) {
            System.out.print(output);
        }
    }
}