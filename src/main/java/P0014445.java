/*

  Problem link: https://quera.org/problemset/14445

*/

public class P0014445 {
    public int StringInString(String one, String two) {
        if ((one == null) || (two == null) || one.isEmpty() || two.isEmpty()) {
            return 0;
        } else {
            int count = 0;

            for (int i = 0; i < one.length() - two.length() + 1; i++) {
                if (one.substring(i, i + two.length()).contains(two)) {
                    count++;
                }
            }

            return count;
        }
    }
}
