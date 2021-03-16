package string;
/**
 * @Description:Given a string S of lowercase letters, a duplicate removal consists of choosing two adjacent and equal letters, and removing them.
 *
 * We repeatedly make duplicate removals on S until we no longer can.
 *
 * Return the final string after all such duplicate removals have been made.  It is guaranteed the answer is unique.
 *
 *
 *
 * Example 1:
 *
 * Input: "abbaca"
 * Output: "ca"
 * Explanation:
 * For example, in "abbaca" we could remove "bb" since the letters are adjacent and equal, and this is the only possible move.  The result of this move is that the string is "aaca", of which only "aa" is possible, so the final string is "ca".
 *
 *
 * Note:
 *
 * 1 <= S.length <= 20000
 * S consists only of English lowercase letters.
 * @Author:      alex
 * @CreateDate:  2019/5/23 10:35
 * @param
 * @return
*/
public class RemoveAllAdjacentDuplicatesInString {
    public static void main(String[] args) {
        RemoveAllAdjacentDuplicatesInString removeAllAdjacentDuplicatesInString=new RemoveAllAdjacentDuplicatesInString();
        System.out.println(removeAllAdjacentDuplicatesInString.removeDuplicates("abbaca"));
    }
    public String removeDuplicates(String S) {
        char[] strs=S.toCharArray();
        for(int i=1;i<strs.length;i++){
            int add=1;
            while(i-add>-1&&strs[i-add]==' ') {
                add++;
            }
            if (i-add>=0&&strs[i]==strs[i-add]){
                strs[i]=' ';
                strs[i-add]=' ';
            }
        }
        StringBuilder sb=new StringBuilder();
        for (int j=0; j<strs.length;j++) {
            if (strs[j]!=' ') {
                sb.append(strs[j]);
            }
        }
        return sb.toString();
    }
    public String removeDuplicates1(String S) {
        char[] strs=S.toCharArray();
        boolean[] flags=new boolean[strs.length];
        for(int i=1;i<strs.length;i++){
            int add=1;
            while(i-add>-1&&flags[i-add]) {
                add++;
            }
            if (i-add>=0&&strs[i]==strs[i-add]){
                flags[i]=true;
                flags[i-add]=true;
            }
        }
        StringBuilder sb=new StringBuilder();
        for (int j=0; j<flags.length;j++) {
            if (!flags[j]) {
                sb.append(strs[j]);
            }
        }
        return sb.toString();
    }
}
