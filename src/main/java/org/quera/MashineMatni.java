package org.quera;

import java.util.Scanner;

public class MashineMatni {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO.input();
    }

    private static StringBuilder operate(StringBuilder string, String[] command) {
        StringBuilder result = new StringBuilder();

        switch (command[0]) {
            case "SHIFT-R": {
                int length = string.length();

                if (length == 0) {
                    result.append(string);
                } else {
                    int n = Integer.parseInt(command[1]) % length;
                    n = (n < 0) ? n + length : n;

                    result.append(string.subSequence(length - n, length));
                    result.append(string.subSequence(0, length - n));
                }

                break;
            }
            case "SHIFT-L": {
                int length = string.length();

                if (length == 0) {
                    result.append(string);
                } else {
                    int n = Integer.parseInt(command[1]) % length;
                    n = (n < 0) ? n + length : n;

                    result.append(string.subSequence(n, length));
                    result.append(string.subSequence(0, n));
                }

                break;
            }
            case "EXTEND": {
                result.append(string);

                result.append("*".repeat(Integer.parseInt(command[1])));

                break;
            }
            case "SHRINK": {
                int n = Integer.parseInt(command[1]);

                if (n >= string.length()) {
                    result.setLength(0);
                } else {
                    result.append(string.subSequence(0, string.length() - n));
                }

                break;
            }
            case "REVERSE": {
                result.append(string.reverse());

                break;
            }
            case "PUT": {
                int index = Integer.parseInt(command[1]) - 1;

                if ((index >= 0) && (index < string.length())) {
                    result.append(string);

                    result.setCharAt(index, command[2].charAt(0));
                } else {
                    result.append(string);
                }

                break;
            }
            default: {
                return string;
            }
        }

        return result;
    }

    private static StringBuilder controller(StringBuilder string, String[] operator) {
        return switch (operator[0]) {
            case "PRINT" -> {
                IO.output(string);
                yield string;
            }
            case "EXIT" -> {
                System.exit(0);

                yield string;
            }
            default -> operate(string, operator);
        };
    }

    private record IO() {
        private static final Scanner SCANNER = new Scanner(System.in);

        static void input() {
            StringBuilder string = new StringBuilder(SCANNER.nextLine());

            while (SCANNER.hasNextLine()) {
                String[] command = SCANNER.nextLine().split(" ");

                string = controller(string, command);
            }
        }

        static void output(Object output) {
            System.out.println(output);
        }
    }
}