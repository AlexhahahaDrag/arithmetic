package twoDimensionalArray;

/**
 *description:
 *author:       alex
 *createDate:   2022/4/26 6:55
 *version:      1.0.0
 */
public class ProjectionArea {

    public int projectionArea(int[][] grid) {
        int sum = 0;
        int[] y = new int[grid.length];
        for (int[] ints : grid) {
            int columnMax = 0;
            for (int j = 0; j < ints.length; j++) {
                sum += (ints[j] == 0 ? 0 : 1);
                columnMax = Math.max(columnMax, ints[j]);
                if (y[j] < ints[j]) {
                    sum += ints[j] - y[j];
                    y[j] = ints[j];
                }
            }
            sum += columnMax;
        }
        return sum;
    }


    public static void main(String[] args) {
        int[][] grid = {{0, 2}, {1, 0}};//8
        ProjectionArea projectionArea = new ProjectionArea();
        System.out.println(projectionArea.projectionArea(grid));
    }
}
