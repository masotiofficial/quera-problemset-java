package P0169494;

import java.math.BigDecimal;
import java.math.RoundingMode;

/*

  Problem link: https://quera.org/problemset/169494

*/

public class ExecutionTimeCalculator {
    public static long functionToCall() {
        long returnValue = 0;
        for (long i = 1; i < 1000L * 1000 * 1000 * 10; i++) {
            returnValue += i;
        }
        return returnValue;
    }

    public static BigDecimal measureExecutionTime(Runnable function) {
        // TODO: Implement
        long start = System.nanoTime();
        function.run();
        long end = System.nanoTime();

        BigDecimal nanoSecondTime = BigDecimal.valueOf(end - start);
        BigDecimal secondTime = nanoSecondTime.divide(BigDecimal.valueOf(1_000_000_000), 5, RoundingMode.HALF_UP);

        return secondTime;
    }

    public static void main(String[] args) {
        System.out.println(measureExecutionTime(ExecutionTimeCalculator::functionToCall));
    }
}
