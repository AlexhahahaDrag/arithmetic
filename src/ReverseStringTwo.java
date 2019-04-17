/**
 * @Description:
 *Given a string and an integer k, you need to reverse the first k characters for every 2k characters counting from the start of the string. If there are less than k characters left, reverse all of them. If there are less than 2k but greater than or equal to k characters, then reverse the first k characters and left the other as original.
 * Example:
 * Input: s = "abcdefg", k = 2
 * Output: "bacdfeg"
 *
 * Input: s = "abcdefg", k = 8
 * Output: "gfedcba"
 *
 * Input: s = "hyzqyljrnigxvdtneasepfahmtyhlohwxmkqcdfehybknvdmfrfvtbsovjbdhevlfxpdaovjgunjqlimjkfnqcqnajmebeddqsgl", k = 39
 * Output: "fdcqkmxwholhytmhafpesaentdvxginrjlyqzyhehybknvdmfrfvtbsovjbdhevlfxpdaovjgunjqllgsqddebemjanqcqnfkjmi"
 * Restrictions:
 * The string consists of lower English letters only.
 * Length of the given string and k will in the range [1, 10000]
 * @Author:      alex
 * @CreateDate:  2019/1/24 13:33
 * @param
 * @return
*/
public class ReverseStringTwo {
    public static void main(String[] args) {
        String s = "hyzqyljrnigxvdtneasepfahmtyhlohwxmkqcdfehybknvdmfrfvtbsovjbdhevlfxpdaovjgunjqlimjkfnqcqnajmebeddqsgl";
        System.out.println(reverseStr(s,39));
    }
    public static String reverseStr(String s,int k){
        char[] strs=s.toCharArray();
        int index=0;
        while(index<=strs.length){
            int start=index;
            int end=(start+k-1)>=strs.length?strs.length-1:(start+k-1);
            while(start<end){
                strs[start]=(char)(strs[start]^strs[end]);
                strs[end]=(char)(strs[start]^strs[end]);
                strs[start]=(char)(strs[start]^strs[end]);
                start++;
                end--;
            }
            index+=k<<1;
        }
        return new String(strs);
    }
}
