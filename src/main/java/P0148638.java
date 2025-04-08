import java.util.Arrays;
import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/148638

*/

public class P0148638 {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(String.join("\n", determineFinalResults(input.games)));
    }

    private static String[] determineFinalResults(Game[] games) {
        return Arrays.stream(games)
                .map(Game::determineFinalResult)
                .toArray(String[]::new);
    }

    private record Game(
            int firstTeamGoalsInFirstLeg,
            int secondTeamGoalsInFirstLeg,
            int firstTeamGoalsInSecondLeg,
            int secondTeamGoalsInSecondLeg
    ) {
        private String determineFinalResult() {
            int firstTeamGoalsCount = firstTeamGoalsInFirstLeg + firstTeamGoalsInSecondLeg;
            int secondTeamGoalsCount = secondTeamGoalsInFirstLeg + secondTeamGoalsInSecondLeg;

            if (firstTeamGoalsCount > secondTeamGoalsCount) {
                return "perspolis";
            } else if (firstTeamGoalsCount < secondTeamGoalsCount) {
                return "esteghlal";
            } else {
                if (secondTeamGoalsInFirstLeg > firstTeamGoalsInSecondLeg) {
                    return "esteghlal";
                } else if (secondTeamGoalsInFirstLeg < firstTeamGoalsInSecondLeg) {
                    return "perspolis";
                } else {
                    return "penalty";
                }
            }
        }
    }

    private record IO(Game[] games) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            int t = SCANNER.nextInt();

            Game[] games = new Game[t];
            for (int i = 0; i < t; i++) {
                games[i] = new Game(SCANNER.nextInt(), SCANNER.nextInt(), SCANNER.nextInt(), SCANNER.nextInt());
            }

            return new IO(games);
        }

        static void output(Object output) {
            System.out.println(output);
        }
    }
}