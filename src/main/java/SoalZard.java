import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/3537

*/

public class SoalZard {
    public static void main(String[] args) {
        toBeSurprised(Input.getInput().n);
    }

    private static void toBeSurprised(int n) {
        System.out.println("W" + "o".repeat(n) + "w!");
    }

    private record Input(int n) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static Input getInput() {
            return new Input(SCANNER.nextInt());
        }
    }
}
