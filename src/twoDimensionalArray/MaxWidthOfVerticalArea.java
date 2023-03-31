package twoDimensionalArray;

import java.util.Arrays;
import java.util.Comparator;

public class MaxWidthOfVerticalArea {

    public int maxWidthOfVerticalArea1(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(o -> o[0]));
        int res = 0;
        for(int i = 0; i < points.length - 1; i++) {
            res = Math.max(res, points[i + 1][0] - points[i][0]);
        }
        return res;
    }

    public int maxWidthOfVerticalArea(int[][] points) {
        int max = points[0][0];
        int min = points[0][0];
        int len = points.length;
        for (int i = 0; i < len; i++) {
            min = Math.min(min, points[i][0]);
            max = Math.max(max, points[i][0]);
        }
        int dif = max - min;
        if (dif == 0) {
            return 0;
        }
        int[][] res = new int[len + 1][2];
        for(int[] i : res) {
            i[0] = Integer.MAX_VALUE;
            i[1] = Integer.MIN_VALUE;
        }
        for (int[] p : points) {
            int index = (int)((long)(p[0] - min) * len / dif);
            res[index][0] = Math.min(p[0], res[index][0]);
            res[index][1] = Math.max(p[0], res[index][1]);
        }
        int result = 0;
        for(int i = 0, last = res[0][1]; i < len; i++) {
            if (res[i][0] != Integer.MAX_VALUE) {
                result = Math.max(result, res[i][0] - last);
                last = res[i][1];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] points = {{8, 7}, {9, 9}, {7, 4}, {9, 7}};
        MaxWidthOfVerticalArea maxWidthOfVerticalArea = new MaxWidthOfVerticalArea();
        System.out.println(maxWidthOfVerticalArea.maxWidthOfVerticalArea1(points));
        System.out.println(maxWidthOfVerticalArea.maxWidthOfVerticalArea(points));
    }
}
