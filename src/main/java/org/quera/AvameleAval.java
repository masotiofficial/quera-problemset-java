package org.quera;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/*

  Problem link: https://quera.org/problemset/298

*/

public class AvameleAval {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(decomposePrimeFactors(input.n())
                .entrySet().stream()
                .map(e -> e.getKey() + (e.getValue() != 1 ? "^" + e.getValue() : ""))
                .collect(Collectors.joining("*"))
        );
    }

    private static Map<Integer, Integer> decomposePrimeFactors(int n) {
        Map<Integer, Integer> primeFactors = new HashMap<>();

        if (isPrime(n)) {
            primeFactors.put(n, 1);
        } else {
            int firstFactor = 1;
            int secondFactor = n;

            while (!isPrime(secondFactor)) {
                if (secondFactor % firstFactor == 0) {
                    if (isPrime(firstFactor)) {
                        if (primeFactors.containsKey(firstFactor)) {
                            primeFactors.put(firstFactor, primeFactors.get(firstFactor) + 1);
                        } else {
                            primeFactors.put(firstFactor, 1);
                        }

                        secondFactor /= firstFactor;

                        if (isPrime(secondFactor)) {
                            if (primeFactors.containsKey(secondFactor)) {
                                primeFactors.put(secondFactor, primeFactors.get(secondFactor) + 1);
                            } else {
                                primeFactors.put(secondFactor, 1);
                            }
                        }
                    } else {
                        firstFactor++;
                    }
                } else {
                    firstFactor++;
                }
            }
        }

        return primeFactors;
    }

    private static boolean isPrime(int n) {
        if (n == 1) {
            return false;
        }

        if (n == 2) {
            return true;
        }

        if (n == 3) {
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
            System.out.print(output);
        }
    }
}