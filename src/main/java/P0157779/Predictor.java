package P0157779;

/*

  Problem link: https://quera.org/problemset/157779

*/

public class Predictor {
    public static int predict(int year) {
        // TODO: Implement
        if (isWorldCupYear(year)) {
            return year;
        } else {
            while (!isWorldCupYear(year)) {
                year++;
            }

            return year;
        }
    }

    public static boolean isWorldCupYear(int year) {
        return year % 4 == 2;
    }

    public static void main(String[] args) {
        System.out.println(predict(2021)); // 2022
        System.out.println(predict(2022)); // 2022
        System.out.println(predict(2023)); // 2026
    }
}