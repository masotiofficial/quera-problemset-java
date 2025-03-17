import java.util.Scanner;
import java.util.Stack;

/*

  Problem link: https://quera.org/problemset/1368
  Problem link: https://quera.org/problemset/335

*/

public class JameChandLaye {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        sumOfSubsets(IO.input().set);
    }

    private static void sumOfSubsets(String[] set) {
        Stack<Integer> numbers = new Stack<>();
        Stack<String> braces = new Stack<>();

        int sum = 0;
        for (String token : set) {
            if (token.equals("{") || token.equals(",")) {
                braces.push(token);
            } else if (token.equals("}")) {
                while (!braces.peek().equals("{")) {
                    braces.pop();

                    sum += numbers.pop();
                }
                braces.pop();

                sum += numbers.pop();
                numbers.push(sum);

                IO.output(sum);
                sum = 0;
            } else {
                numbers.push(Integer.parseInt(token));
            }
        }
    }

    private record IO(String[] set) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            return new IO(
                    SCANNER.nextLine()
                    .replace("{", " { ")
                    .replace("}", " } ")
                    .replace(",", " , ")
                    .trim()
                    .split("\\s+")
            );
        }

        static void output(Object output) {
            System.out.println(output);
        }
    }
}
