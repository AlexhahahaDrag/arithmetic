package string;

import java.util.HashMap;
import java.util.Map;

/**
 *description:  
 *author:       alex
 *createDate:  2020/2/17 19:04
 *version:      1.0.0      
*/
public class CheckPermutation {

    public boolean CheckPermutation1(String s1, String s2) {
        if(s1.length() != s2.length())
            return false;
        Map<Character, Integer> map = new HashMap<>();
        char[] ch1 = s1.toCharArray();
        char[] ch2 = s2.toCharArray();
        int len = s1.length();
        for(int i = 0; i < len; i++) {
            map.put(ch1[i], map.getOrDefault(ch1[i], 0) + 1);
            map.put(ch2[i], map.getOrDefault(ch2[i], 0) - 1);
        }
        for (Integer i : map.values())
            if (i != 0)
                return false;
        return true;
    }

    public boolean CheckPermutation(String s1, String s2) {
        if(s1.length() != s2.length())
            return false;
        int[] res = new int[26];
        char[] ch1 = s1.toCharArray();
        char[] ch2 = s2.toCharArray();
        int len = s1.length();
        for(int i = 0; i < len; i++) {
            res[ch1[i] - 'a']++;
            res[ch2[i] - 'a']--;
        }
        for (int i : res)
            if (i != 0)
                return false;
        return true;
    }
}
