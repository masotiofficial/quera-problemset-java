import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/66872

*/

public class P0066872 {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(input.validator.isValidated() ? "Eyval" : "HeifShod");
    }

    private static class Validator {
        private int goodnessLevel;
        private String suspiciousString;
        final String[] commands;

        private Validator(String suspiciousString, String[] commands) {
            this.goodnessLevel = 0;
            this.suspiciousString = suspiciousString;
            this.commands = commands;
        }

        public boolean isValidated() {
            for (String command : commands) {
                String[] commandParts = command.split("\\s+");

                switch (commandParts[0]) {
                    case "copy": {
                        suspiciousString = copy(commandParts[1], Integer.parseInt(commandParts[2]));

                        break;
                    }
                    case "compare": {
                        compare(commandParts[1]);

                        break;
                    }
                    case "substr": {
                        substr(commandParts[1], Integer.parseInt(commandParts[2]));

                        break;
                    }
                    case "attach": {
                        attach(commandParts[1], Integer.parseInt(commandParts[2]), commandParts[3]);

                        break;
                    }
                    case "length": {
                        length(Integer.parseInt(commandParts[1]));

                        break;
                    }
                }
            }

            return goodnessLevel >= commands.length / 2;
        }

        private String copy(String key, int count) {
            key = key.repeat(count);

            return key + suspiciousString.substring(key.length());
        }

        private void compare(String key) {
            goodnessLevel = suspiciousString.equals(key) ? goodnessLevel + 1 : goodnessLevel;
        }

        private void substr(String key, int count) {
            int repeatCount = 0;

            for (int i = 0; i <= suspiciousString.length() - key.length(); i++) {
                if (suspiciousString.startsWith(key, i)) {
                    repeatCount++;
                }
            }

            goodnessLevel = repeatCount == count ? goodnessLevel + 1 : goodnessLevel;
        }

        private void attach(String key, int count, String str) {
            String keyConcatStr = key.concat(str);

            substr(keyConcatStr, count);
        }

        private void length(int count) {
            goodnessLevel = suspiciousString.length() == count ? goodnessLevel + 1 : goodnessLevel;
        }
    }

    private record IO(Validator validator) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            String suspiciousString = SCANNER.nextLine();

            List<String> commands = new ArrayList<>();
            while (SCANNER.hasNextLine()) {
                String command = SCANNER.nextLine();

                if (!command.equals("Is it right or not?")) {
                    commands.add(command);
                } else {
                    break;
                }
            }

            return new IO(new Validator(suspiciousString, commands.toArray(new String[0])));
        }

        static void output(Object output) {
            System.out.println(output);
        }
    }
}