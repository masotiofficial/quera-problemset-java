import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/110015

*/

public class P0110015 {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(generateExhibitionMap(input.k()));
    }

    private static String generateExhibitionMap(int boothCount) {
        return ExhibitionMapBuilder.placeBooths(boothCount);
    }

    private static class ExhibitionMapBuilder {
        private static final String BOOTH_PLACEHOLDER = "\\?\\?\\?\\?\\?\\?\\?";
        private static final String EMPTY_BOOTH = ".......";
        private static final String BASE_NAME = "ghorfe";
        private static final String BASE_MAP = """
                ########.......########
                #???????.......???????#
                ########.......########
                #???????.......???????#
                ########.......########
                #???????.......???????#
                ########.......########
                #???????.......???????#
                #######################
                """;

        public static String placeBooths(int boothCount) {
            String boothsMap = BASE_MAP;

            for (int i = 1; i <= boothCount; i++) {
                boothsMap = boothsMap.replaceFirst(BOOTH_PLACEHOLDER, BASE_NAME + i);
            }

            boothsMap = boothsMap.replaceAll(BOOTH_PLACEHOLDER, EMPTY_BOOTH);

            return boothsMap;
        }
    }

    private record IO(int k) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            return new IO(SCANNER.nextInt());
        }

        static void output(Object output) {
            System.out.println(output);
        }
    }
}