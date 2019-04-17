import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description:Given an array A of strings made only from lowercase letters, return a list of all characters that show up in all strings within the list (including duplicates).  For example, if a character occurs 3 times in all strings but not 4 times, you need to include that character three times in the final answer.
 *
 * You may return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: ["bella","label","roller"]
 * Output: ["e","l","l"]
 * Example 2:
 *
 * Input: ["cool","lock","cook"]
 * Output: ["c","o"]
 *
 *
 * Note:
 *
 * 1 <= A.length <= 100
 * 1 <= A[i].length <= 100
 * A[i][j] is a lowercase letter
 * @Author:      alex
 * @CreateDate:  2019/3/4 9:32
 * @param
 * @return
*/
public class FindCommonCharacters {
    public static void main(String[] args) {
        String[] A={"bella","label","roller"};
        System.out.println(commonChars(A));
    }
    public static List<String> commonChars(String[] A) {
        List<Character> list=null;
        int[] index=new int[26];
        for(char a:A[0].toCharArray())
            index[a-'a']++;
        for(int i=1;i<A.length;i++){
            list=new LinkedList<>();
            for(char a:A[i].toCharArray()){
                if(index[a-'a']>0){
                    list.add(a);
                    index[a-'a']--;
                }
            }
            index=new int[26];
            for(char b:list){
                index[b-'a']++;
            }
        }
        List<String> list2=new ArrayList<>();
        for (char c:list)
            list2.add(new String(new char[]{c}));
        return list2;
    }
}
