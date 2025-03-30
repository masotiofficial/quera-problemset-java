import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/176774

*/

public class JameBastani {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(openFingersCount(input.fingersPerHand(), input.hands(), input.firstNumber(), input.secondNumber()));
    }

    private static int openFingersCount(int fingersPerHand, int hands, int firstNumber, int secondNumber) {
        int sum = firstNumber + secondNumber;
        int fingers = hands * fingersPerHand;
        int remainder = sum % fingers;

        return (sum != 0) && (remainder == 0) ? fingers : remainder;
    }

    private record IO(int fingersPerHand, int hands, int firstNumber, int secondNumber) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            return new IO(SCANNER.nextInt(), SCANNER.nextInt(), SCANNER.nextInt(), SCANNER.nextInt());
        }

        static void output(Object output) {
            System.out.println(output);
        }
    }
}