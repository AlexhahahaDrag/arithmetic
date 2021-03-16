package string;

/**
 *description:  
 *author:       alex
 *createDate:  2020/2/9 12:14
 *version:      1.0.0      
*/
public class MinSteps {

    public int minSteps(String s, String t) {
        int[] map = new int[26];
        int index = 0;
        int len = s.length();
        while(index < len) {
            map[s.charAt(index++) - 'a']++;
            map[t.charAt(index++) - 'a']--;
        }
        int sum = 0;
        for(int i : map) {
            if(i > 0) {
                sum += i;
            }
        }
        return sum;
    }
}
