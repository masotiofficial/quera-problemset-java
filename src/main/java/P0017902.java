import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*

  Problem link: https://quera.org/problemset/17902

*/

public class P0017902 {
    public static void main(String[] args) throws IOException {
        process();
    }

    private static void process() throws IOException {
        IO input = IO.input();

        IO.output(minRotations(input.k, input.password, input.wheels));
    }

    private static int minRotations(int k, String password, String[] wheels) {
        int count = 0;

        int index;
        for (int i = 0; i < k; i++) {
            index = wheels[i].indexOf(password.charAt(i));

            count += Math.min(index, 9 - index);
        }

        return count;
    }

    private record IO(int k, String password, String[] wheels) {
        private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));

        static IO input() throws IOException {
            int k = Integer.parseInt(READER.readLine().trim());

            String password = READER.readLine().trim();

            String[] wheels = new String[k];
            for (int i = 0; i < k; i++) {
                wheels[i] = READER.readLine().trim();
            }

            return new IO(k, password, wheels);
        }

        static void output(Object output) {
            System.out.println(output);
        }
    }
}