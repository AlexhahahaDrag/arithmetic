import java.util.HashSet;
import java.util.Set;

/**
 * @Description:一个字符串的非空子串是指字符串中长度至少为 1 的连续的一段字符组成
 * 的串。例如，字符串aaab 有非空子串a, b, aa, ab, aaa, aab, aaab，一共 7 个。
 * 注意在计算时，只算本质不同的串的个数。
 * 请问，字符串0100110001010001 有多少个不同的非空子串？
 * @Author:      alex
 * @CreateDate:  2019/5/8 15:19
 * @param
 * @return
*/
public class DifferentSubstring {
    public static void main(String[] args) {
        System.out.println(getDifferentSubstring("0100110001010001"));
    }
    public static int getDifferentSubstring(String s){
        int start=0;
        int len=s.length();
        Set set=new HashSet();
        while(start<=len-1){
            int end=start+1;
            while(end<=len){
                set.add(s.substring(start,end));
                end++;
            }
            start++;
        }
        return set.size();
    }
}
