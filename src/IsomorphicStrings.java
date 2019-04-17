/**
 * @Description: Given two strings s and t, determine if they are isomorphic.
 *
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 *
 * All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.
 *
 * Example 1:
 *
 * Input: s = "egg", t = "add"
 * Output: true
 * Example 2:
 *
 * Input: s = "foo", t = "bar"
 * Output: false
 * Example 3:
 *
 * Input: s = "paper", t = "title"
 * Output: true
 * @Author:      alex
 * @CreateDate:  2019/2/15 11:27
 * @param
 * @return
*/
public class IsomorphicStrings {
    public static void main(String[] args) {
        System.out.println(isIsomorphic1("",""));
    }
    public static boolean isIsomorphic(String s, String t) {
        if (s.length()!=t.length())
            return false;
        for (int i = 0; i < s.length(); i++)
            if(s.lastIndexOf(s.charAt(i))!=t.lastIndexOf(t.charAt(i)))
                return false;
        return true;
    }
    public static boolean isIsomorphic1(String s, String t) {
        char[] sString = s.toCharArray();
        char[] tString = t.toCharArray();
        int length = sString.length;
        if(length != tString.length) return false;
        char[] sm = new char[256];
        char[] tm = new char[256];
        for(int i=0; i<length; i++){
            char sc = sString[i];
            char tc = tString[i];
            if(sm[sc] == 0 && tm[tc] == 0){
                sm[sc] = tc;
                tm[tc] = sc;
            }else{
                if(sm[sc] != tc || tm[tc] != sc)
                    return false;
            }
        }
        return true;
    }

}
