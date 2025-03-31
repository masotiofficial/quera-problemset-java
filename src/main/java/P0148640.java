import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

/*

  Problem link: https://quera.org/problemset/148640

*/

public class P0148640 {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO.input();
    }

    private static int correctTheExam(String key, String[] answers) {
        AtomicInteger t = new AtomicInteger();
        AtomicInteger f = new AtomicInteger();

        key = keyFromLettersToDigits(key);

        for (int i = 0; i < key.length(); i++) {
            String answer = answers[i];

            int index = answer.indexOf("#");
            int lastIndex = answer.lastIndexOf("#");

            if (index != -1) {
                if (index == lastIndex) {
                    if (index == Character.getNumericValue(key.charAt(i))) {
                        t.getAndIncrement();
                    } else {
                        f.getAndIncrement();
                    }
                } else {
                    f.getAndIncrement();
                }
            }
        }

        return 3 * t.get() - f.get();
    }

    private static String keyFromLettersToDigits(String key) {
        return key
                .replaceAll("A", "0")
                .replaceAll("B", "1")
                .replaceAll("C", "2")
                .replaceAll("D", "3");
    }

    private record IO() {
        private static final Scanner SCANNER = new Scanner(System.in);

        static void input() {
            int n = Integer.parseInt(SCANNER.nextLine());
            String s = SCANNER.nextLine();
            int k = Integer.parseInt(SCANNER.nextLine());

            for (int i = 0; i < k; i++) {
                String[] answers = new String[n];

                for (int j = 0; j < n; j++) {
                    answers[j] = SCANNER.nextLine();
                }

                IO.output(correctTheExam(s, answers));
            }
        }

        static void output(Object output) {
            System.out.println(output);
        }
    }
}