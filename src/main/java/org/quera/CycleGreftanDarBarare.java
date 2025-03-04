package org.quera;

import java.util.*;
import java.util.stream.IntStream;

/*

  Problem link: https://quera.org/problemset/10166

*/

public class CycleGreftanDarBarare {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        Person keyvoon = new Person("keyvoon", personAnswers(input.n, "331122"));
        keyvoon.score = correct(input.keyQuestions, keyvoon.answer);

        Person nezam = new Person("nezam", personAnswers(input.n, "123"));
        nezam.score = correct(input.keyQuestions, nezam.answer);

        Person shirFarhad = new Person("shir farhad", personAnswers(input.n, "2123"));
        shirFarhad.score = correct(input.keyQuestions, shirFarhad.answer);

        Person[] people = new Person[]{keyvoon, nezam, shirFarhad};

        Arrays.sort(people);

        IO.output(people[0].score);

        for (Person person : people) {
            if (person.score == people[0].score) {
                IO.output(person.name);
            }
        }
    }

    private static int correct(String keyQuestions, String answer) {
        return (int) IntStream.range(0, keyQuestions.length())
                .filter(i -> keyQuestions.charAt(i) == answer.charAt(i))
                .count();
    }

    private static String personAnswers(int n, String pattern) {
        int remainder = n % pattern.length();

        return pattern.repeat(n / pattern.length()).concat(remainder != 0 ? pattern.substring(0, remainder) : "");
    }

    private static class Person implements Comparable<Person> {
        final String name;
        final String answer;
        int score;

        Person(String name, String answer) {
            this.name = name;
            this.answer = answer;
        }

        @Override
        public int compareTo(Person o) {
            if (this.score == o.score) {
                return this.name.compareTo(o.name);
            } else {
                return o.score - score;
            }
        }
    }

    private record IO(int n, String keyQuestions) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            return new IO(Integer.parseInt(SCANNER.nextLine()), SCANNER.nextLine());
        }

        static void output(Object output) {
            System.out.println(output);
        }
    }
}