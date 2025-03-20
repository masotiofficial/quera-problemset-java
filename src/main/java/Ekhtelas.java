import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/177664

*/

public class Ekhtelas {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(findTopEmbezzler(input.n, input.embezzlementInfo));
    }

    private static String findTopEmbezzler(int n, Map<String, Integer> embezzlementInfo) {
        String topEmbezzlerName = "";

        int maxAmountEmbezzlement = 0;
        for (Map.Entry<String, Integer> info : embezzlementInfo.entrySet()) {
            if (info.getValue() > maxAmountEmbezzlement) {
                maxAmountEmbezzlement = info.getValue();
                topEmbezzlerName = info.getKey();
            }
        }

        return topEmbezzlerName;
    }

    private record IO(int n, Map<String, Integer> embezzlementInfo) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            int n = SCANNER.nextInt();

            Map<String, Integer> embezzlementInfo = new HashMap<>();
            for (int i = 0; i < n; i++) {
                embezzlementInfo.put(SCANNER.next(), SCANNER.nextInt());
            }

            return new IO(n, embezzlementInfo);
        }

        static void output(Object output) {
            System.out.println(output);
        }
    }
}