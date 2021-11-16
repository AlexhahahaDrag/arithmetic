package twoDimensionalArray;

/**
 *description:  
 *author:       alex
 *createDate:   2021/11/16 21:30
 *version:      1.0.0
 */
public class UpdateMatrix {

    public int[][] updateMatrix1(int[][] mat) {
        int row = mat.length;
        int column = mat[0].length;
        int num = 0;
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < column; j++) {
                if(mat[i][j] == 1) {
                    mat[i][j] = -1;
                    num++;
                }
            }
        }

        int in = 0;
        int[][] d = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        l:while(num > 0) {
            for(int i = 0; i < row; i++) {
                for(int j = 0; j < column; j++) {
                    if(mat[i][j] == in) {
                        for(int k = 0; k < 4; k++) {
                            if(i + d[k][0] >= 0 && i + d[k][0] < row
                                    && j + d[k][1] >= 0 && j + d[k][1] < column
                                    && mat[i + d[k][0]][j + d[k][1]] == -1
                            ) {
                                mat[i + d[k][0]][j + d[k][1]] = in + 1;
                                num--;
                                if(num == 0) {
                                    break l;
                                }
                            }
                        }
                    }
                }
            }
            in++;
        }
        return mat;
    }

    public int[][] updateMatrix(int[][] mat) {
        int row = mat.length;
        int column = mat[0].length;
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < column; j++) {
                if(mat[i][j] == 1) {
                    mat[i][j] = 10001;
                }
            }
        }
        for (int i = 1; i < row; i++) {
            mat[i][0] = Math.min(mat[i][0], mat[i - 1][0] + 1);
        }
        for (int j = 1; j < column; j++) {
            mat[0][j] = Math.min(mat[0][j], mat[0][j - 1] + 1);
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < column; j++) {
                mat[i][j] = Math.min(mat[i][j], Math.min(mat[i - 1][j], mat[i][j - 1]) + 1);
            }
        }
        for (int i = row - 2; i >= 0; i--) {
            mat[i][column - 1] = Math.min(mat[i][column - 1], mat[i + 1][column - 1]);
        }
        for (int l = column - 2; l >= 0; l--) {
            mat[row - 1][l] = Math.min(mat[row - 1][l], mat[row - 1][l + 1] + 1);
        }
        for (int m = row - 2; m >= 0; m--) {
            for (int n = column - 2; n >= 0; n--) {
                mat[m][n] = Math.min(mat[m][n], Math.min(mat[m + 1][n], mat[m][n + 1]) + 1);
            }
        }
        return mat;
    }

    public static void main(String[] args) {
//        int[][] mat = {{0 , 0, 0}, {0, 1, 0}, {1, 1, 1}};
        int[][] mat = {{0,1,0,1,1},{1,1,0,0,1},{0,0,0,1,0},{1,0,1,1,1},{1,0,0,0,1}};
        UpdateMatrix updateMatrix = new UpdateMatrix();
        int[][] res = updateMatrix.updateMatrix(mat);
        for(int[] i : res) {
            for(int j : i) {
                System.out.print(j + ",");
            }
            System.out.println();
        }
    }
}
