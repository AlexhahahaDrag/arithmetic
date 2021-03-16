package twoDimensionalArray;

/**
 *description:
 *author:       alex
 *createDate:   2020/9/13 10:51
 *version:      1.0.0
 */
public class NumSpecial {

    public int numSpecial(int[][] mat) {
        int[] row = new int[mat.length];
        int[] column = new int[mat[0].length];
        for(int i = 0; i < mat.length; i++) {
            int sum = 0;
            for(int j = 0; j < mat[i].length; j++) {
                sum += mat[i][j];
            }
            row[i] = sum;
        }
        for(int i = 0; i < mat[0].length; i++) {
            int sum = 0;
            for(int j = 0; j < mat.length; j++) {
                sum += mat[i][j];
            }
            column[i] = sum;
        }
        int one = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1 && row[i] + column[j] == 2) {
                    one++;
                }
            }
        }
        return one;
    }

    public static void main(String[] args) {

    }
}
