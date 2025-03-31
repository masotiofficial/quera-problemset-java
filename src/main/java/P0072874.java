import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/72874

*/

public class P0072874 {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO.output(message());
    }

    private static String message() {
        return "Bebakhshid, vali shoma nemitoonin too in mosabeghe sherkat konin :";
    }

    private record IO() {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            return new IO();
        }

        static void output(Object output) {
            System.out.println(output);
        }
    }
}