import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/244100

*/

public class AzDotNetBeGolang {
    public static void main(String[] args) {
        converter();
    }

    private static void converter() {
        System.out.print(Input.getInput().s.replace(".NET", "Golang"));
    }

    private record Input(String s) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static Input getInput() {
            return new Input(SCANNER.nextLine());
        }
    }
}