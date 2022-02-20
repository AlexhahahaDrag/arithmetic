package array;

import java.util.Arrays;

public class EarliestFullBloom {

    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        int[][] res = new int[plantTime.length][2];
        for (int i = 0; i < plantTime.length; i++) {
            res[i][0] = plantTime[i];
            res[i][1] = growTime[i];
        }
        Arrays.sort(res, (o1, o2) ->  o1[0] * o2[1] - o1[1] * o2[0]);
        int p = 0;
        int g = 0;
        for(int[] r : res) {
            p += r[0];
            g = Math.max(g, p + r[1]);
        }
        return g;
    }

    public static void main(String[] args) {
//        int[] plantTime = {1,2,3,2};//9
//        int[] growTime = {2,1,2,1};
//        int[] plantTime = {1,4,3};//9
//        int[] growTime = {2,3,1};
//        int[] plantTime = {1};//1
//        int[] growTime = {1};
        int[] plantTime = {22,19,18,2,7,30};//105
        int[] growTime = {10,7,20,29,24,9};
        EarliestFullBloom earliestFullBloom = new EarliestFullBloom();
        System.out.println(earliestFullBloom.earliestFullBloom(plantTime, growTime));
    }
}
