import java.util.Scanner;

/*

  Problem link: https://quera.org/problemset/275495

*/

public class FlowerFestival {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        IO input = IO.input();

        IO.output(findFastCar(input.f, input.cars).number);
    }

    private static Car findFastCar(int streetLength, Car[] cars) {
        Car result = null;

        double minTime = Double.MAX_VALUE;
        for (Car car : cars) {
            double time = (double) (streetLength - car.location) / car.speed;

            if (time < minTime) {
                minTime = time;

                result = car;
            }
        }

        return result;
    }

    private record Car(int number, int location, int speed) {
    }

    private record IO(int f, Car[] cars) {
        private static final Scanner SCANNER = new Scanner(System.in);

        static IO input() {
            int n = SCANNER.nextInt();
            int f = SCANNER.nextInt();

            Car[] cars = new Car[n];
            for (int i = 0; i < n; i++) {
                cars[i] = new Car(i + 1, SCANNER.nextInt(), SCANNER.nextInt());
            }

            return new IO(f, cars);
        }

        static void output(Object output) {
            System.out.println(output);
        }
    }
}