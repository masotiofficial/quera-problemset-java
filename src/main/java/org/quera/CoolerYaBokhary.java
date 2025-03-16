package org.quera;

import java.util.Arrays;
import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/147635

*/

public class CoolerYaBokhary {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        Arrays.stream(detectModes(input.n, input.temperatures))
                .forEach(mode -> IO.output(mode.device));
    }

    private static Modes[] detectModes(int n, int[] temperatures) {
        return Arrays.stream(temperatures)
                .mapToObj(Modes::detect)
                .toArray(Modes[]::new);
    }

    private enum Modes {
        HOT("cooler"),
        COLD("heater");

        final String device;

        Modes(String device) {
            this.device = device;
        }

        static Modes detect(int temperature) {
            if (temperature > 15) {
                return HOT;
            } else {
                return COLD;
            }
        }
    }

    private record IO(int n, int[] temperatures) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            int n = SCANNER.nextInt();

            int[] temperatures = new int[n];
            for (int i = 0; i < n; i++) {
                temperatures[i] = SCANNER.nextInt();
            }

            return new IO(n, temperatures);
        }

        static void output(Object output) {
            System.out.println(output);
        }
    }
}