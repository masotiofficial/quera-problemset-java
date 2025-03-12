package org.quera;

import java.util.Arrays;
import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/3430

*/

public class BolandGo {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        Arrays.stream(echoSound(input.word)).forEach(IO::output);
    }

    private static String[] echoSound(String word) {
        String[] echoWord = new String[word.length()];

        for (int i = 0; i < word.length(); i++) {
            echoWord[i] = String.valueOf(word.charAt(i)).repeat(i) + word.substring(i, echoWord.length);
        }

        return echoWord;
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