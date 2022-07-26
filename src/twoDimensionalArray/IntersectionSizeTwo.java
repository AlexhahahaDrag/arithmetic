package twoDimensionalArray;


import java.util.Arrays;

public class IntersectionSizeTwo {

    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[1] == b[1]) {
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });
        int res = 2;
        int max = intervals[0][1];
        for(int[] i : intervals) {
            if (max - i[0] >= 2) {
                continue;
            }
            if (max < i[0]) {
                res += i[0] - max + 2;
                max = i[0] + 2;
            } else {

            }
        }
        return res;
    }

    public static void main(String[] args) {
//        int[][] intervals = {{1,3},{1,4},{2,5},{3,5}};//3
//        int[][] intervals = {{1, 2}, {2, 3}, {2, 4}, {4, 5}};//5
        int[][] intervals = {{2,10},{3,7},{3,15},{4,11},{6,12},{6,16},{7,8},{7,11},{7,15},{11,12}};//5
        IntersectionSizeTwo intersectionSizeTwo = new IntersectionSizeTwo();
        System.out.println(intersectionSizeTwo.intersectionSizeTwo(intervals));
    }
}
