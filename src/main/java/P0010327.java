import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

/*

  Problem link: https://quera.org/problemset/10327

*/

public class P0010327 {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(Arrays.stream(input.codes)
                .map(code -> isValidCode(code, input.t) ? "Yes" : "No")
                .collect(Collectors.joining("\n"))
        );
    }

    private static boolean isValidCode(String code, String allowedChars) {
        Set<Character> codeSet = code.chars()
                .mapToObj(ch -> (char) ch)
                .collect(Collectors.toSet());

        Set<Character> allowedCharsSet = allowedChars.chars()
                .mapToObj(ch -> (char) ch)
                .collect(Collectors.toSet());

        return codeSet.equals(allowedCharsSet);
    }

    private record IO(String t, String[] codes) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            int n = SCANNER.nextInt();
            String t = SCANNER.next();
            SCANNER.nextLine();

            String[] codes = new String[n];
            for (int i = 0; i < n; i++) {
                codes[i] = SCANNER.nextLine();
            }

            return new IO(t, codes);
        }

        static void output(Object output) {
            System.out.println(output);
        }
    }
}