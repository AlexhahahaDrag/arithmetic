package twoDimensionalArray;

public class MaxSideLength {

    int max = 0;
    int sum = 0;
    public int maxSideLength(int[][] mat, int threshold) {
        for (int i = 0; i + max < mat.length; i++) {
            for (int j = 0; j + max < mat[i].length; j++) {
                find (mat, i, j, sum, max, threshold);
            }
        }
        return max;
    }

    private void find(int[][] mat, int i, int j, int sum, int max, int threshold) {
        if (i + max >= mat.length || j + max >= mat[0].length)
            return;
        int xIn = 0;
        int tSum = 0;
        if (i - 1 > 0) {
            int yIn = 0;
            tSum = sum;
            while (yIn < max)
                tSum -= mat[i - 1][j + yIn] + mat[i + max][j + yIn];
            if (tSum > threshold)
                sum = tSum;
            else {
                while (judge(mat, i, j, sum, max + 1, threshold))
                    max++;
            }
        } else {
            for (int a = i; a <= i + max; a++)
                for(int b = j; b <= j + max; b++)
                    tSum += mat[a][b];
                sum = tSum;
            if(tSum <= threshold) {
                while (judge(mat, i, j, sum, max + 1, threshold))
                    max++;
            }
        }
    }

    private boolean judge(int[][] mat, int i, int j, int sum, int max, int threshold) {
        int tSum = sum;
        if (i + max >= mat.length || j + max >= mat[0].length)
            return false;
        for (int a = i; a <= i + max; i++)
            tSum += mat[a][j + max];
        if (tSum > threshold)
            return false;
        for(int b = j; b < j + max; j++)
            tSum += mat[i + max][b];
        if (tSum <= threshold) {
            sum = tSum;
            return true;
        }else
            return false;
    }

    public static void main(String[] args) {
        MaxSideLength maxSideLength = new MaxSideLength();
        int[][] mat = {{1, 1, 3, 2, 4, 3, 2}, {1, 1, 3, 2, 4, 3, 2}, {1, 1, 3, 2, 4, 3, 2}};
        int threshold = 4;
        System.out.println(maxSideLength.maxSideLength(mat, threshold));
    }
}
