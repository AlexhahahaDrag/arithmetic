package array;

import java.util.Arrays;

public class BestTeamScore {
    public int bestTeamScore(int[] scores, int[] ages) {
        int[][] map = new int[ages.length][2];
        for(int i = 0; i < ages.length; i++) {
            map[i][0] = ages[i];
            map[i][1] = scores[i];
        }
        Arrays.sort(map, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int[] dp = new int[ages.length];
        dp[0] = map[0][1];
        int max = dp[0];
        for (int i = 1; i < ages.length; i++) {
            if (map[i][0] == map[i - 1][0] && map[i][1] == map[i - 1][1]) {
                dp[i] = dp[i - 1] + map[i][1];
            } else {
                dp[i] = map[i][1];
                for (int j = i - 1; j >= 0; j--) {
                    if (map[j][1] <= map[i][1]) {
                        dp[i] = Math.max(dp[i], dp[j] + map[i][1]);
                    }
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
//        int[] scores = {4,5,6,5};
//        int[] ages = {2,1,2,1};
//        int[] scores = {1,1,1,1,1,1,1,1,1,1};
//        int[] ages = {811,364,124,873,790,656,581,446,885,134};
//        int[] scores = {1,2,3,5};
//        int[] ages = {8,9,10,1};
        int[] scores = {1};
        int[] ages = {4};
        BestTeamScore bestTeamScore = new BestTeamScore();
        System.out.println(bestTeamScore.bestTeamScore(scores, ages));
    }
}
