import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/*

  Problem link: https://quera.org/problemset/148099

*/

public class P0148099 {
    public static void main(String[] args) {
        computeUniqueXOR();
    }

    private static void computeUniqueXOR() {
        System.out.print(computeXOR(Input.getInput().films()));
    }

    private static int computeXOR(Object[] films) {
        int xor = 0;

        for (Object o : films) {

            xor ^= (int) o;
        }

        return xor;
    }

    private record Input(Object[] films) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static Input getInput() {
            return new Input(getA(SCANNER.nextInt()));
        }

        private static Object[] getA(int n) {
            Set<Integer> films = new HashSet<>();

            for (int i = 0; i < n; i++) {
                int number = SCANNER.nextInt();

                if (films.contains(number)) {
                    films.remove(number);
                } else {
                    films.add(number);
                }
            }

            return films.toArray();
        }
    }
}
