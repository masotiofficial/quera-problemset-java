import java.util.ArrayList;
import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/140032

*/

public class P0140032 {
    public static void main(String[] args) {
        possibilityBuildTriangle();
    }

    private static void possibilityBuildTriangle() {
        try {
            differentTriangles(Input.getInput().woods, 0, new ArrayList<>());

            System.out.println("NO");
        } catch (Exception e) {
            System.out.println("YES");
        }
    }

    private static void differentTriangles(int[] woods, int start, ArrayList<Integer> current) throws Exception {
        if (current.size() == 3) {
            if (isTriangle(current.get(0), current.get(1), current.get(2))) {
                throw new Exception();
            }
        }

        for (int i = start; i < woods.length; i++) {
            current.add(woods[i]);

            differentTriangles(woods, i + 1, current);

            current.remove(current.size() - 1);
        }
    }

    private static boolean isTriangle(int x, int y, int z) {
        return (x + y > z) && (x + z > y) && (y + z > x);
    }

    private record Input(int[] woods) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static Input getInput() {
            int[] woods = new int[5];
            for (int i = 0; i < 5; i++) {
                woods[i] = SCANNER.nextInt();
            }

            return new Input(woods);
        }
    }
}