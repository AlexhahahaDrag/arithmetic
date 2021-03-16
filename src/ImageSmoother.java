/**
 * @Description:Given a 2D integer matrix M representing the gray scale of an image, you need to design a smoother to make the gray scale of each cell becomes the average gray scale (rounding down) of all the 8 surrounding cells and itself. If a cell has less than 8 surrounding cells, then use as many as you can.
 *
 * Example 1:
 * Input:
 * {{1,1,1},
 *  {1,0,1},
 *  {1,1,1}}
 * Output:
 * {{0, 0, 0},
 *  {0, 0, 0},
 *  {0, 0, 0}}
 * Explanation:
 * For the point (0,0), (0,2), (2,0), (2,2): floor(3/4) = floor(0.75) = 0
 * For the point (0,1), (1,0), (1,2), (2,1): floor(5/6) = floor(0.83333333) = 0
 * For the point (1,1): floor(8/9) = floor(0.88888889) = 0
 * Note:
 * The value in the given matrix is in the range of {0, 255}.
 * The length and width of the given matrix are in the range of {1, 150}.
 * @Author:      alex
 * @CreateDate:  2019/5/13 14:43
 * @param
 * @return
 */
public class ImageSmoother {
    public static void main(String[] args) {
        int[][] MMore={{2,3,4},{5,6,7},{8,9,10},{11,12,13},{14,15,16}};
        int[][] results=imageSmoother2(MMore);
        for (int i = 0; i <results.length ; i++) {
            for (int j = 0; j < results[0].length; j++) {
                System.out.print(results[i][j]+"   ");
            }
            System.out.println();
        }
    }
    public static int[][] imageSmoother2(int[][] M) {
        int[][] results=new int[M.length][M[0].length];
        for(int i=0;i<M.length;i++) {
            for(int j=0;j<M[0].length;j++){
                int count=0;
                int sum=0;
                for (int k = i-1; k <= i+1; k++) {
                    for (int l = j - 1; l <= j + 1; l++) {
                        if (k >= 0 && k < M.length && l >= 0 && l < M[0].length) {
                            count++;
                            sum += M[k][l];
                        }
                    }
                }
                results[i][j]=sum/count;
            }
        }
        return results;
    }
    public static int[][] imageSmoother1(int[][] M) {
        int[][] MMore=new int[M.length+2][M[0].length+2];
        for(int i=1;i<MMore.length-1;i++) {
            for(int j=1;j<MMore[0].length-1;j++) {
                MMore[i][j] = M[i - 1][j - 1];
            }
        }
        for (int i = 0; i < MMore.length; i++) {
            MMore[i][0]=-1;
            MMore[i][MMore[0].length-1]=-1;
        }
        for (int j = 1; j < MMore[0].length-1; j++) {
            MMore[0][j]=-1;
            MMore[MMore.length-1][j]=-1;
        }
        int[][] results=new int[M.length][M[0].length];
        for(int i=1;i<MMore.length-1;i++) {
            for(int j=1;j<MMore[0].length-1;j++){
                int count=0;
                int sum=0;
                for (int k = i-1; k <= i+1; k++) {
                    for (int l = j - 1; l <= j + 1; l++) {
                        if (MMore[k][l] != -1) {
                            count++;
                            sum += MMore[k][l];
                        }
                    }
                }
                results[i-1][j-1]=sum/count;
            }
        }
        return results;
    }
    public static int[][] imageSmoother(int[][] M) {
        int[][] ret = new int[M.length][M[0].length];
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[0].length; j++) {
                ret[i][j] = getAverage(M, i, j);
            }
        }
        return ret;
    }

    private static int getAverage (int[][] M, int i, int j) {
        int size = 1, run = M[i][j];
        if (i > 0) {
            run += M[i-1][j];
            size++;
            if (j > 0) {
                run += M[i-1][j-1];
                size++;
            }
            if (j < M[0].length-1) {
                run += M[i-1][j+1];
                size++;
            }
        }
        if (i < M.length - 1) {
            run += M[i+1][j];
            size++;
            if (j > 0) {
                run += M[i+1][j-1];
                size++;
            }
            if (j < M[0].length-1) {
                run += M[i+1][j+1];
                size++;
            }
        }
        if (j > 0) {
            run += M[i][j-1];
            size++;
        }
        if (j < M[0].length-1) {
            run += M[i][j+1];
            size++;
        }

        return run/size;
    }
}
