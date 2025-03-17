import java.util.Scanner;
import java.util.Stack;

/*

  Problem link: https://quera.org/problemset/3405

*/

public class ChapeBarAks {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        Stack<String> s = new Stack<>();

        String next;
        while (true) {
            next = SCANNER.nextLine();

            if (next.equals("0")) {
                break;
            } else {
                s.push(next);
            }
        }

        while (!s.isEmpty()) {
            System.out.println(s.pop());
        }
    }
}
