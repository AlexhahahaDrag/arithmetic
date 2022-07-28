package twoDimensionalArray;

/**
 *description:  
 *author:       majf
 *createDate:   2022/6/14 12:47
 *version:      1.0.0
 */
public class FindDiagonalOrder {

    private int[] res;
    private int index = 0;
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        res = new int[m * n];
        int sum = -1;
        while(++sum <= (m - 1) + (n - 1)) {
            if ((sum & 1) == 0) {
                findJ(mat, sum, m, n);
            } else {
                findI(mat, sum, m, n);
            }
        }
        return res;
    }

    private void findI(int[][] mat, int sum, int m, int n) {
        for(int i = 0; i < m && i <= sum; i++) {
            if (sum - i >= 0 && sum - i < n) {
                res[index++] = mat[i][sum - i];
            }
        }
    }

    private void findJ(int[][] mat, int sum, int m, int n) {
        for(int j = 0; j < n && j <= sum; j++) {
            if (sum - j >= 0 && sum - j < m) {
                res[index++] = mat[sum - j][j];
            }
        }
    }

    public static void main(String[] args) {
//        int[][] mat = {{1,2,3}, {4,5,6}, {7,8,9}};//1,2,4,7,5,3,6,8,9
        int[][] mat = {{1, 2}, {3, 4}};
        FindDiagonalOrder findDiagonalOrder = new FindDiagonalOrder();
        int[] res = findDiagonalOrder.findDiagonalOrder(mat);
        for(int i : res) {
            System.out.print(i + ",");
        }
    }
}
