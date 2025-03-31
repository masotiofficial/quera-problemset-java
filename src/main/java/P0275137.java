import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/275137

*/

public class P0275137 {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(selectVilla(input.k, input.villas).number);
    }

    private static Villa selectVilla(int peopleNumber, Villa[] villas) {
        Villa result = null;

        int minCost = Integer.MAX_VALUE;
        for (Villa villa : villas) {
            int cost = villa.calculateCost(peopleNumber);

            if (cost < minCost) {
                minCost = cost;

                result = villa;
            }
        }

        return result;
    }

    private record Villa(int number, int baseCost, int additionalCost, int baseNumber) {
        public int calculateCost(int peopleNumber) {
            int additionalPeople = Math.max(0, peopleNumber - baseNumber);

            return baseCost + additionalPeople * additionalCost;
        }
    }

    private record IO(int k, Villa[] villas) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            int n = SCANNER.nextInt();
            int k = SCANNER.nextInt() + 1;

            Villa[] villas = new Villa[n];
            for (int i = 0; i < n; i++) {
                villas[i] = new Villa(i + 1, SCANNER.nextInt(), SCANNER.nextInt(), SCANNER.nextInt());
            }

            return new IO(k, villas);
        }

        static void output(Object output) {
            System.out.println(output);
        }
    }
}