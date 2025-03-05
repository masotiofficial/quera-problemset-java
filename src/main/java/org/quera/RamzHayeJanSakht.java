package org.quera;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/9722

*/

public class RamzHayeJanSakht {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        for (String password : combinations(IO.input().n)) {
            IO.output(password);
        }
    }

    private static List<String> combinations(int n) {
        int[] firstDigits = new int[]{2, 3, 5, 7};
        int[] otherDigits = new int[]{1, 3, 7, 9};

        List<String> passwords = new ArrayList<>();
        for (int digit : firstDigits) {
            combinationsHelper(otherDigits, n, 1, String.valueOf(digit), passwords);
        }

        return passwords;
    }

    private static void combinationsHelper(int[] otherDigits, int n, int length, String current, List<String> result) {
        if (length == n) {
            if (isPrime(Integer.parseInt(current))) {
                result.add(current);
            }

            return;
        }

        for (int digit : otherDigits) {
            String newNumber = current + digit;

            if (isPrime(Integer.parseInt(newNumber))) {
                combinationsHelper(otherDigits, n, length + 1, newNumber, result);
            }
        }
    }

    private static boolean isPrime(int n) {
        if (n == 1) {
            return false;
        }

        if ((n == 2) || (n == 3)) {
            return true;
        }

        if (n % 2 == 0 || n % 3 == 0) {
            return false;
        }

        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }

        return true;
    }

    private record IO(int n) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            return new IO(SCANNER.nextInt());
        }

        static void output(Object output) {
            System.out.println(output);
        }
    }
}