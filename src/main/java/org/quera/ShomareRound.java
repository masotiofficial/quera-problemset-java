package org.quera;

import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/91713

*/

public class ShomareRound {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO.input();
    }

    private static boolean isRound(String number) {
        return maxRepeatedDigits(number) >= 4 || sequenceRepeatedDigits(number) >= 3 || isPalindrome(number);
    }

    private static boolean isPalindrome(String number) {
        int left = 0;
        int right = number.length() - 1;

        while (left < right) {
            if (number.charAt(left++) != number.charAt(right--)) {
                return false;
            }
        }

        return true;
    }

    private static int sequenceRepeatedDigits(String number) {
        int max = 1;
        int count = 1;

        for (int i = 1; i < number.length(); i++) {
            if (number.charAt(i) == number.charAt(i - 1)) {
                count++;
                max = Math.max(max, count);
            } else {
                count = 1;
            }
        }
        
        return max;
    }

    private static int maxRepeatedDigits(String number) {
        int[] counts = new int[10];

        for (int i = 0; i < number.length(); i++) {
            counts[number.charAt(i) - '0']++;
        }

        int max = 0;
        for (int count : counts) {
            max = Math.max(max, count);
        }

        return max;
    }

    private record IO() {
        private static final Scanner SCANNER = new Scanner(System.in);

        static void input() {
            int t = SCANNER.nextInt();
            SCANNER.nextLine();
            for (int i = 0; i < t; i++) {
                output(isRound(SCANNER.nextLine()) ? "Ronde!" : "Rond Nist");
            }
        }

        static void output(Object output) {
            System.out.println(output);
        }
    }
}