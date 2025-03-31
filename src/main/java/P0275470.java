import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/275470

*/

public class P0275470 {
    public static void main(String[] args) {
        answer();
    }

    private static void answer() {
        System.out.println(countSheeps(Input.getInput().n));
    }

    private static int countSheeps(int legs) {
        return legs / 4;
    }

    private record Input(int n) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static Input getInput() {
            return new Input(SCANNER.nextInt());
        }
    }
}
