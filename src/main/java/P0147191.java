import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/147191

*/

public class P0147191 {
    public static void main(String[] args) {
        commonArea();
    }

    private static void commonArea() {
        System.out.println(calculateArea(Input.getInput().a));
    }

    private static double calculateArea(int a) {
        return (1 - Math.sqrt(3) + Math.PI / 3) * Math.pow(a, 2);
    }

    private record Input(int a) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static Input getInput() {
            return new Input(SCANNER.nextInt());
        }
    }
}