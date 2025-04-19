import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/62451

*/

public class P0062451 {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(determineCollisionStatus(input.personOne(), input.personTwo()));
    }

    private static CollisionStatus determineCollisionStatus(Person personOne, Person personTwo) {
        double collisionTime = calculateCollisionTime(personOne, personTwo);

        return CollisionStatus.determine(collisionTime);
    }

    private static double calculateCollisionTime(Person personOne, Person personTwo) {
        double locationDifference = personTwo.initialLocation() - personOne.initialLocation();
        double velocityDifference = personOne.velocity() - personTwo.velocity();

        return locationDifference / velocityDifference;
    }

    private enum CollisionStatus {
        SEE_YOU("SEE YOU"),
        BORO_BORO("BORO BORO"),
        WAIT_WAIT("WAIT WAIT");

        private final String message;

        CollisionStatus(String message) {
            this.message = message;
        }

        public static CollisionStatus determine(double collisionTime) {
            if (collisionTime < 0) {
                return BORO_BORO;
            } else if (collisionTime > 0) {
                return SEE_YOU;
            } else {
                return WAIT_WAIT;
            }
        }

        @Override
        public String toString() {
            return message;
        }
    }

    private record Person(int velocity, int initialLocation) {
    }

    private record IO(Person personOne, Person personTwo) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            Person personOne = new Person(SCANNER.nextInt(), SCANNER.nextInt());
            Person personTwo = new Person(SCANNER.nextInt(), SCANNER.nextInt());

            return new IO(personOne, personTwo);
        }

        static void output(Object output) {
            System.out.print(output);
        }
    }
}