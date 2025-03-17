import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/193460

*/

public class MarioVaOnlineShop {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        System.out.println(calculateAbilityToBuySwords(input.Cm, input.Gm, input.Cs, input.Gs, input.rate) ? "Yes" : "No");
    }

    private static boolean calculateAbilityToBuySwords(int Cm, int Gm, int Cs, int Gs, int rate) {
        boolean available = true;
        double difference;

        if (Cm < Cs) {
            difference = Math.ceil((double) (Cs - Cm) / rate);

            available = (difference <= Gm) && (Gm - difference >= Gs);
        } else if (Gm < Gs) {
            difference = (Gs - Gm) * rate;

            available = (difference <= Cm) && (Cm - difference >= Cs);
        }

        return available;
    }

    private record IO(int Cm, int Gm, int Cs, int Gs, int rate) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            return new IO(SCANNER.nextInt(), SCANNER.nextInt(), SCANNER.nextInt(), SCANNER.nextInt(), SCANNER.nextInt());
        }

        static void output(Object output) {
            System.out.println(output);
        }
    }
}