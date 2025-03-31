import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/2551

*/

public class P0002551 {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(operation(input.a, input.operation, input.b));
    }

    private static StringBuilder operation(StringBuilder a, String operation, StringBuilder b) {
        return switch (operation) {
            case "+" -> add(a, b);
            case "*" -> multiply(a, b);
            default -> throw new IllegalArgumentException("Unsupported operation: " + operation);
        };
    }

    private static StringBuilder add(StringBuilder a, StringBuilder b) {
        if (a.length() > b.length()) {
            a.setCharAt(a.length() - b.length(), '1');

            return a;
        } else if (a.length() < b.length()) {
            b.setCharAt(b.length() - a.length(), '1');

            return b;
        } else {
            a.setCharAt(0, '2');

            return a;
        }
    }

    private static StringBuilder multiply(StringBuilder a, StringBuilder b) {
        return new StringBuilder("1" + "0".repeat(a.length() + b.length() - 2));
    }

    private record IO(StringBuilder a, String operation, StringBuilder b) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            return new IO(new StringBuilder(SCANNER.nextLine()), SCANNER.nextLine(), new StringBuilder(SCANNER.nextLine()));
        }

        static void output(Object output) {
            System.out.println(output);
        }
    }
}