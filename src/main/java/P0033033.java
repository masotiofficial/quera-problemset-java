/*

  Problem link: https://quera.org/problemset/33033

*/

public class P0033033 {
    public int[][][] coloring(int[][][] cube) {
        for (int i = 0; i < cube.length; i++) {
            for (int j = 0; j < cube[i].length; j++) {
                for (int k = 0; k < cube[i][j].length; k++) {
                    if ((i == 0) || (i == cube.length - 1)) {
                        cube[i][j][k] = 1;
                    } else if ((j == 0) || (j == cube[i].length - 1)) {
                        cube[i][j][k] = 1;
                    } else if ((k == 0) || (k == cube[i][j].length - 1)) {
                        cube[i][j][k] = 1;
                    } else {
                        cube[i][j][k] = 0;
                    }
                }
            }
        }

        return cube;
    }
}
