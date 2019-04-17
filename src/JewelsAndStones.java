import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @Description: You're given strings J representing the types of stones that are jewels, and S representing the stones you have.  Each character in S is a type of stone you have.  You want to know how many of the stones you have are also jewels.
 *
 * The letters in J are guaranteed distinct, and all characters in J and S are letters. Letters are case sensitive, so "a" is considered a different type of stone from "A".
 *
 * Example 1:
 *
 * Input: J = "aA", S = "aAAbbbb"
 * Output: 3
 * Example 2:
 *
 * Input: J = "z", S = "ZZ"
 * Output: 0
 * Note:
 *
 * S and J will consist of letters and have length at most 50.
 * The characters in J are distinct.
 * @Author:      alex
 * @CreateDate:  2019/2/13 11:19
 * @param
 * @return
*/
public class JewelsAndStones {
    public static void main(String[] args) {
        System.out.println(numJewelsInStones("z","ZZ"));
    }
    public static int numJewelsInStones(String J, String S) {
        Map<Character,Integer> map=new HashMap<>();
        for (int i = 0; i < J.length(); i++)
            map.put(J.charAt(i),0);
        int count=0;
        for (int i = 0; i < S.length(); i++)
            if (map.containsKey(S.charAt(i)))
                count++;
        return count;
    }
    public static int numJewelsInStones1(String J, String S) {
        if(J == null || S == null || J.length() == 0 || S.length() == 0) return 0;
        boolean[] jewel = new boolean[128];
        for(char c : J.toCharArray())
            jewel[c] = true;
        int res = 0;
        for(char c : S.toCharArray())
            if(jewel[c]) ++res;
        return res;
    }
}
