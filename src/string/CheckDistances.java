package string;

import java.util.Arrays;

public class CheckDistances {

    public boolean checkDistances(String s, int[] distance) {
        int[] map = new int[26];
        Arrays.fill(map, -1);
        int i = -1;
        int len = s.length();
        while(++i < len) {
            char cur = s.charAt(i);
            if (map[cur -'a'] == -1) {
                map[cur - 'a'] = i;
            } else if (i - map[cur - 'a'] - 1 != distance[cur - 'a']) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "abaccb";
        int[] distance = {1,3,0,5,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        CheckDistances checkDistances = new CheckDistances();
        System.out.println(checkDistances.checkDistances(s, distance));
    }
}
