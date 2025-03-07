package org.quera;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/17904

*/

public class BadKonakHa {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(burstingDay(input.balloons));
    }

    private static List<Balloon> burstingDay(List<Balloon> balloons) {
        List<Balloon> balloonsTemp = new ArrayList<>();

        int day = 1;
        int count = 0;
        int i = 0;
        while (balloons.size() < 3) {
            while (!balloons.get(i).equals(balloonsTemp.get(i + 1))) {
                Balloon balloon = balloonsTemp.get(i).copy(day);
                balloonsTemp.add(balloon);

                i++;
            }

            if(balloonsTemp.size() >= 3) {

            }

            day++;
        }

        return balloons;
    }

    private static class Balloon {
        final int number;
        final int color;
        int burstingDay = -1;

        private Balloon(int number, int color) {
            this.number = number;
            this.color = color;
        }

        public boolean equals(Balloon o) {
            return color == o.color;
        }

        public Balloon copy(int day) {
            Balloon b = new Balloon(number, color);
            b.burstingDay = day;

            return b;
        }


    }

    private record IO(List<Balloon> balloons) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            int n = SCANNER.nextInt();

            List<Balloon> balloons = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                balloons.add(new Balloon(i, SCANNER.nextInt()));
            }

            return new IO(balloons);
        }

        static void output(Object output) {
            System.out.println(output);
        }
    }
}