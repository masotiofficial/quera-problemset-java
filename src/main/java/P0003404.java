import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/3404

*/

public class P0003404 {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(statusBMI(input.n, input.m));
    }

    private static String statusBMI(int weight, double height) {
        double BMI = BMI(weight, height);
        String formattedBMI = String.format("%.2f", BMI);

        if (BMI < 18.5) {
            return formattedBMI + "\nUnderweight";
        } else if ((BMI >= 18.5) && (BMI < 25.0)) {
            return formattedBMI + "\nNormal";
        } else if ((BMI >= 25.0) && (BMI < 30.0)) {
            return formattedBMI + "\nOverweight";
        } else {
            return formattedBMI + "\nObese";
        }
    }

    public static double BMI(int weight, double height) {
        return weight / (height * height);
    }

    private record IO(int n, double m) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            return new IO(SCANNER.nextInt(), SCANNER.nextDouble());
        }

        static void output(Object output) {
            System.out.println(output);
        }
    }
}