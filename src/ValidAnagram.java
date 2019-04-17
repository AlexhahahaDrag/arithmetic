/**
 * Given two strings s and t , write a function to determine if t is an anagram of s.
 *
 * Example 1:
 *
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 * Example 2:
 *
 * Input: s = "rat", t = "car"
 * Output: false
 */
public class ValidAnagram {
    public static void main(String[] args) {
        String s="nagaramt";
        String t="anagramt";
        System.out.println(isValid(s,t));
    }
    public static boolean isValid(String s,String t){
        int[] container=new int[26];
        byte[] sbyte=s.getBytes();
        byte[] tbyte=t.getBytes();
        for (int i = 0; i < sbyte.length; i++) {
            container[sbyte[i]-'a']++;
        }
        for (int i = 0; i < tbyte.length; i++) {
            container[tbyte[i]-'a']--;
            if (container[tbyte[i]-'a']<0)
                return false;
        }
        for (int i = 0; i < container.length; i++) {
            if (container[i]!=0)
                return false;
        }
        return true;
    }
}
