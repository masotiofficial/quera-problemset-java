package org.quera;

import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/292

*/

public class KarBaAdadeAshari {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(computeStatistics(input.numbers));
    }

    private static String computeStatistics(double[] numbers) {
        DoubleSummaryStatistics statistics = Arrays.stream(numbers).summaryStatistics();

        double max = threeDecimal(statistics.getMax());
        double min = threeDecimal(statistics.getMin());
        double avg = threeDecimal(statistics.getAverage());

        return String.format(
                "Max: %.3f%nMin: %.3f%nAvg: %.3f",
                max,
                min,
                avg
        );
    }

    private static double threeDecimal(double number) {
        return Math.floor(number * 1000) / 1000.0;
    }

    private record IO(double[] numbers) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            int n = SCANNER.nextInt();

            double[] numbers = new double[n];
            for (int i = 0; i < n; i++) {
                numbers[i] = SCANNER.nextDouble();
            }

            return new IO(numbers);
        }

        static void output(Object output) {
            System.out.println(output);
            ;
        }
    }
}