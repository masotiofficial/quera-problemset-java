import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/26109

*/

public class ICPC {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(determineWinner(input.p_1, input.s_1, input.s_2, input.p_2));
    }

    private static String determineWinner(int p_1, int s_1, int s_2, int p_2) {
        int persepolisGoals = p_1 + p_2;
        int esteghlalGoals = s_1 + s_2;

        if (persepolisGoals > esteghlalGoals) {
            return "Persepolis";
        } else if (esteghlalGoals > persepolisGoals) {
            return "Esteghlal";
        } else {
            if (p_2 > s_1) {
                return "Persepolis";
            } else if (s_1 > p_2) {
                return "Esteghlal";
            } else {
                return "Penalty";
            }
        }
    }

    private record IO(int p_1, int s_1, int s_2, int p_2) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            return new IO(SCANNER.nextInt(), SCANNER.nextInt(), SCANNER.nextInt(), SCANNER.nextInt());
        }

        static void output(Object output) {
            System.out.println(output);
        }
    }
}