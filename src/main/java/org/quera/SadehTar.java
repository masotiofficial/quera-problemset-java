package org.quera;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*

  Problem link: https://quera.org/problemset/3403

*/

public class SadehTar {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(statisticalIndicators(input.numbers));
    }

    private static String statisticalIndicators(int[] numbers) {
        double sum = Arrays.stream(numbers).sum();
        double average = sum / numbers.length;
        double product = Arrays.stream(numbers).reduce(1, (a, b) -> a * b);
        double max = Arrays.stream(numbers).max().orElse(0);
        double min = Arrays.stream(numbers).min().orElse(0);

        String format = "%.6f";

        return Stream.of(
                        Map.entry("Sum", sum),
                        Map.entry("Average", average),
                        Map.entry("Product", product),
                        Map.entry("MAX", max),
                        Map.entry("MIN", min)
                )
                .map(e -> e.getKey() + " : " + String.format(format, e.getValue()))
                .collect(Collectors.joining("\n"));
    }

    private record IO(int[] numbers) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            int[] numbers = new int[4];

            for (int number = 0; number < numbers.length; number++) {
                numbers[number] = SCANNER.nextInt();
            }

            return new IO(numbers);
        }

        static void output(Object output) {
            System.out.println(output);
        }
    }
}