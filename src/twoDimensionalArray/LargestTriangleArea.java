package twoDimensionalArray;

/**
 *description:  
 *author:       alex
 *createDate:   2022/5/15 14:55
 *version:      1.0.0
 */
public class LargestTriangleArea {

    public double largestTriangleArea(int[][] points) {
        double res = 0.0;
        for(int i = 0; i < points.length - 2; i++) {
            for(int j = i + 1; j < points.length - 1; j++) {
                for(int k = j + 1; k < points.length; k++) {
                    res = Math.max(res, area(points[i], points[j], points[k]));
                }
            }
        }
        return res;
    }

    private double area(int[] one, int[] two, int[] three) {
        return (double)Math.abs(one[0] * two[1] - one[0] * three[1] + two[0] * three[1] - two[0] * one[1] + three[0] * one[1] - three[0] * two[1] ) / 2;
    }

    public static void main(String[] args) {
//        int[][] points = {{0,0}, {0,1}, {1,0}, {0,2}, {2, 0}};//2.0

        int[][] points = {{1,0},{0,0},{0,1}};
        LargestTriangleArea largestTriangleArea = new LargestTriangleArea();
        System.out.println(largestTriangleArea.largestTriangleArea(points));
    }
}
