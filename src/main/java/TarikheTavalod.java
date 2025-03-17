import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/615

*/

public class TarikheTavalod {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO.output(detecteBirthDate(IO.input().birthDate));
    }

    private static String detecteBirthDate(String birthDate) {
        return "saal:" + birthDate.substring(0, 2) + "\n" + "maah:" + birthDate.substring(2, 4);
    }

    private record IO(String birthDate) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            return new IO(SCANNER.nextLine());
        }

        static void output(Object output) {
            System.out.println(output);
        }
    }
}