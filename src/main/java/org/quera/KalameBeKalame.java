package org.quera;

import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/108665

*/

public class KalameBeKalame {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO.output(pronunciationTypes(IO.input().word));
    }

    private static int pronunciationTypes(String word) {
        int count = 0;

        for(char letter  : word.toCharArray()) {
            if(letter == 'a' || letter == 'e' || letter == 'i' || letter == 'o' || letter == 'u') {
                count++;
            }
        }

        return (int) Math.pow(2, count);
    }

    private record IO(String word) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            return new IO(SCANNER.nextLine());
        }

        static void output(Object output) {
            System.out.println(output);
        }
    }
}