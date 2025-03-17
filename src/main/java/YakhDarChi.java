import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/3429

*/

public class YakhDarChi {
    public static void main(String[] args) {
        waterStatus(Input.getInput().t);
    }

    private static void waterStatus(int t) {
        String status = "";

        if (t > 100) {
            status = "Steam";
        } else if (t < 0) {
            status = "Ice";
        } else {
            status = "Water";
        }

        System.out.println(status);
    }

    private record Input(int t) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static Input getInput() {
            return new Input(SCANNER.nextInt());
        }
    }
}
