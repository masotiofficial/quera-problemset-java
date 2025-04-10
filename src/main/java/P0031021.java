import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/31021

*/

public class P0031021 {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(String.join("\n", findConversations(input.n(), input.studentNames())));
    }

    private static List<String> findConversations(int studentCount, String[] studentNames) {
        List<String> result = new ArrayList<>();

        result.addAll(sayHello(studentCount, studentNames));
        result.addAll(sayGoodBay(studentCount, studentNames));

        return result;
    }

    private static List<String> sayGoodBay(int studentCount, String[] studentNames) {
        List<String> result = new ArrayList<>();

        for (int i = 0; i < studentCount; i++) {
            result.add(goodBayAll(studentNames[i]));

            for (int j = i + 1; j < studentCount; j++) {
                result.add(goodBay(studentNames[j], studentNames[i]));
            }
        }

        return result;
    }

    private static String goodBay(String speaker, String leaver) {
        return speaker + ": khodafez " + leaver + "!";
    }

    private static String goodBayAll(String leaver) {
        return leaver + ": khodafez bacheha!";
    }

    private static List<String> sayHello(int studentCount, String[] studentNames) {
        List<String> result = new ArrayList<>();

        for (int i = 1; i < studentCount; i++) {
            for (int j = i - 1; j >= 0; j--) {
                result.add(hello(studentNames[i], studentNames[j]));
            }
        }

        return result;
    }

    private static String hello(String speaker, String receiver) {
        return speaker + ": salam " + receiver + "!";
    }

    private record IO(int n, String[] studentNames) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            int n = SCANNER.nextInt();

            String[] studentNames = new String[n];
            for (int i = 0; i < n; i++) {
                studentNames[i] = SCANNER.next();
            }

            return new IO(n, studentNames);
        }

        static void output(Object output) {
            System.out.println(output);
        }
    }
}