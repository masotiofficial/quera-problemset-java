import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/244098

*/

public class P0244098 {
    public static void main(String[] args) {
        complementaryColors();
    }

    private static void complementaryColors() {
        for (String color : Input.getInput().colors) {
            System.out.println('#' + formatter(findComplementary(color.substring(1))).toUpperCase());
        }
    }

    private static String formatter(String string) {
        return "0".repeat(6 - string.length()) + string;
    }

    private static String findComplementary(String color) {
        return Integer.toHexString((16777215 - Integer.parseInt(color, 16)));
    }

    private record Input(String[] colors) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static Input getInput() {
            return new Input(getColors(SCANNER.nextInt()));
        }

        private static String[] getColors(int t) {
            String[] colors = new String[t];

            SCANNER.nextLine();
            for (int i = 0; i < t; i++) {
                colors[i] = SCANNER.nextLine();
            }

            return colors;
        }
    }
}