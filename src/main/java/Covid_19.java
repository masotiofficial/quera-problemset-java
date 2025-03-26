import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/275483

*/

public class Covid_19 {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(convertDataToColorCode(input.p, input.q));
    }

    private static String convertDataToColorCode(int newCases, int newHospitalizations) {
        if ((newCases <= 50) && (newHospitalizations <= 10)) {
            return "White";
        } else if (newHospitalizations > 30) {
            return "Red";
        } else {
            return "Yellow";
        }
    }

    private record IO(int p, int q) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            return new IO(SCANNER.nextInt(), SCANNER.nextInt());
        }

        static void output(Object output) {
            System.out.println(output);
        }
    }
}