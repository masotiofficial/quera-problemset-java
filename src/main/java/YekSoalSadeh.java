import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/2885

*/

public class YekSoalSadeh {
    public static void main(String[] args) {
        repeat(Input.getInput().n);
    }

    private static void repeat(int n) {
        System.out.println("man khoshghlab hastam\n".repeat(n));
    }

    private record Input(int n) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static Input getInput() {
            return new Input(SCANNER.nextInt());
        }
    }
}
