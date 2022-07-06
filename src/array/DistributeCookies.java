package array;

import java.util.Arrays;

/**
 *description:  
 *author:       alex
 *createDate:   2022/6/12 11:53
 *version:      1.0.0
 */
public class DistributeCookies {

    public int distributeCookies(int[] cookies, int k) {
        int sum = 0;
        for(int cookie : cookies) {
            sum += cookie;
        }
        int avg = (sum + k - 1) / k;
        Arrays.sort(cookies);
        int[] map = new int[k];
        int s = 0;
        for(int i = cookies.length - 1; i >= 0; i--) {
            if (map[s] + cookies[i] > avg) {
                if(s < k - 1) {
                    s++;
                }
            }
            map[s] += cookies[i];
        }
        int min = 800001;
        for(int i = 0; i < map.length; i++) {
            min = Math.min(min, map[i]);
        }
        return min;
    }

    private void dfs(int[] map, int[] c, boolean[] visited, int k, int avg) {
        if (k == -1) {

        }
        for(int i = 0; i < c.length; i++) {
            if (visited[i]) {
                continue;
            }
//            if ()
        }
    }

    public static void main(String[] args) {
        System.out.println((int)'a');
        System.out.println((int)'A');
    }
}
