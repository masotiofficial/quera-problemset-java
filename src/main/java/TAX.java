import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/6313

*/

public class TAX {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        Arrays.stream(calculateTaxes(input.taxes)).forEach(IO::output);
    }

    private static int[] calculateTaxes(List<Integer> taxes) {
        return taxes.stream().mapToInt(tax -> {
            if (tax > 5000000) {
                return tax * 8 / 10;
            } else if (tax > 1000000) {
                return tax * 9 / 10;
            } else {
                return tax;
            }
        }).toArray();
    }

    private record IO(List<Integer> taxes) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            List<Integer> taxes = new ArrayList<>();

            while (SCANNER.hasNextInt()) {
                int tax = SCANNER.nextInt();

                if (tax == 0) {
                    break;
                } else {
                    taxes.add(tax);
                }
            }

            return new IO(taxes);
        }

        static void output(Object output) {
            System.out.println(output);
        }
    }
}