import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/10162

*/

public class RozeAzadyeBayanDarBarare {
    public static void main(String[] args) {
        angryGang();
    }

    private static void angryGang() {
        System.out.println(isOddOrEven(Input.getInput().k) ? "Payin Barare" : "Bala Barare");
    }

    private static boolean isOddOrEven(int k) {
        return k % 2 != 0;
    }

    private record Input(int k) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static Input getInput() {
            return new Input(SCANNER.nextInt());
        }
    }
}
