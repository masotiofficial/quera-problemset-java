import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/659

*/

public class P0000659 {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(arrangeBooks(input.library(), input.operations()));
    }

    private static Library arrangeBooks(Library library, List<String> operations) {
        for (int i = 0; i < operations.size(); i++) {
            String operation = operations.get(i);

            switch (operation) {
                case "AddLeft": {
                    library.books.addFirst(operations.get(++i));

                    library.booksCount++;

                    break;
                }
                case "AddRight": {
                    library.books.addLast(operations.get(++i));

                    library.booksCount++;

                    break;
                }
                case "DeleteLeft": {
                    library.books.removeFirst();

                    library.booksCount--;

                    break;
                }
            }
        }

        return library;
    }

    private static class Library {
        int booksCount;
        LinkedList<String> books;

        public Library(int booksCount, LinkedList<String> books) {
            this.booksCount = booksCount;
            this.books = books;
        }

        @Override
        public String toString() {
            return booksCount + "\n" + String.join("\n", books);
        }
    }

    private record IO(Library library, List<String> operations) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            int n = Integer.parseInt(SCANNER.nextLine());

            LinkedList<String> books = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                books.add(SCANNER.nextLine());
            }

            List<String> operations = new LinkedList<>();
            while (SCANNER.hasNextLine()) {
                String operation = SCANNER.nextLine();

                if (operation.equals("Exit")) {
                    break;
                } else {
                    operations.add(operation);
                }
            }

            return new IO(new Library(n, books), operations);
        }

        static void output(Object output) {
            System.out.println(output);
        }
    }
}