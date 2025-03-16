package org.quera;

import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/*

  Problem link: https://quera.org/problemset/20256

*/

public class RegimeGhazaie {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(isUnhealthy(input.healthLabel) ? "nakhor lite" : "rahat baash");
    }

    private static boolean isUnhealthy(String healthLabel) {
        Map<Character, Long> healthLevel = healthLabel.chars()
                .mapToObj(ch -> (char) ch)
                .collect(Collectors.groupingBy(ch -> ch, Collectors.counting()));

        long redCount = healthLevel.getOrDefault('R', 0L);
        long yellowCount = healthLevel.getOrDefault('Y', 0L);
        long greenCount = healthLevel.getOrDefault('G', 0L);

        return (redCount >= 3) ||
                ((redCount >= 2) && (yellowCount >= 2)) ||
                (greenCount == 0);
    }

    private record IO(String healthLabel) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            return new IO(SCANNER.nextLine());
        }

        static void output(Object output) {
            System.out.print(output);
        }
    }
}