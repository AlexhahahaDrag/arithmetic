package twoDimensionalArray;

public class MinimumEffortPath {

    private int min = Integer.MAX_VALUE;
    private boolean[][] visited;
    public int minimumEffortPath(int[][] heights) {
        visited = new boolean[heights.length][heights[0].length];
        dfs(heights, 0, 0, 0);
        return min;
    }

    private void dfs(int[][] heights, int i, int j, int cur) {
        if (i == heights.length - 1 && j == heights[0].length - 1) {
            min = Math.min(cur, min);
            return;
        }
        visited[i][j] = true;
        if (i - 1 >= 0 && !visited[i - 1][j] && Math.abs(heights[i - 1][j] - heights[i][j]) < min)
            dfs(heights, i - 1, j, Math.max(Math.abs(heights[i - 1][j] - heights[i][j]), cur));
        if (i + 1 < heights.length && !visited[i + 1][j] && Math.abs(heights[i + 1][j] - heights[i][j]) < min)
            dfs(heights, i + 1, j, Math.max(Math.abs(heights[i + 1][j] - heights[i][j]), cur));
        if (j - 1 >= 0 && !visited[i][j - 1] && Math.abs(heights[i][j - 1] - heights[i][j]) < min)
            dfs(heights, i, j - 1, Math.max(Math.abs(heights[i][j - 1] - heights[i][j]), cur));
        if (j + 1 < heights[0].length && !visited[i][j + 1] && Math.abs(heights[i][j + 1] - heights[i][j]) < min)
            dfs(heights, i ,j + 1, Math.max(Math.abs(heights[i][j + 1] - heights[i][j]), cur));
        visited[i][j] = false;
    }

    public static void main(String[] args) {
        //int[][] heights = {{1,2,1,1,1}, {1,2,1,2,1}, {1,2,1,2,1}, {1,2,1,2,1}, {1,1,1,2,1}};
        System.out.println(((long)Integer.MAX_VALUE + 1) * 2);
        int[][] heights = {{10,8},{10,8},{1,2},{10,3},{1,3},{6,3},{5,2}};
        MinimumEffortPath minimumEffortPath = new MinimumEffortPath();
        System.out.println(minimumEffortPath.minimumEffortPath(heights));
    }
}
