package org.quera;

/*

  Problem link: https://quera.org/problemset/14445

*/

public class RepeatInString {
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
