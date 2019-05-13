/**
 * @Description:S and T are strings composed of lowercase letters. In S, no letter occurs more than once.
 *
 * S was sorted in some custom order previously. We want to permute the characters of T so that they match the order that S was sorted. More specifically, if x occurs before y in S, then x should occur before y in the returned string.
 *
 * Return any permutation of T (as a string) that satisfies this property.
 *
 * Example :
 * Input:
 * S = "cba"
 * T = "abcd"
 * Output: "cbad"
 * Explanation:
 * "a", "b", "c" appear in S, so the order of "a", "b", "c" should be "c", "b", and "a".
 * Since "d" does not appear in S, it can be at any position in T. "dcba", "cdba", "cbda" are also valid outputs.
 *
 *
 * Note:
 *
 * S has length at most 26, and no character is repeated in S.
 * T has length at most 200.
 * S and T consist of lowercase letters only.
 * @Author:      alex
 * @CreateDate:  2019/5/9 10:20
 * @param
 * @return
*/
public class CustomSortString {
    public static void main(String[] args) {
        System.out.println();
    }
    public static String customSortString(String S, String T) {
        StringBuilder sb=new StringBuilder();
        int[] count=new int[26];
        for(char t:T.toCharArray())
            count[t-'a']++;
        for(char s:S.toCharArray()){
            while(count[s-'a']-->0)
                sb.append(s);
        }
        for(char t:T.toCharArray()){
            while(count[t-'a']-->0)
                sb.append(t);
        }
        return sb.toString();
    }
    public static String customSortString1(String S, String T) {
        StringBuilder sb=new StringBuilder();
        char[] strs=T.toCharArray();
        int add=0;
        for(char ch:strs){
            int index=S.indexOf(ch);
            if(index==-1){
                sb.append(ch);
                add++;
            }else{
                int d=add;
                while(d>0&&((S.indexOf(sb.charAt(d-1))==-1)||S.indexOf(sb.charAt(d-1))>index))
                    d--;
                sb.insert(d,ch);
                add++;
            }
        }
        return sb.toString();
    }
}
