/**
 * @Description: The count-and-say sequence is the sequence of integers with the first five terms as following:
 *
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 *
 * Given an integer n where 1 ≤ n ≤ 30, generate the nth term of the count-and-say sequence.
 *
 * Note: Each term of the sequence of integers will be represented as a string.
 *
 *
 *
 * Example 1:
 *
 * Input: 1
 * Output: "1"
 * Example 2:
 *
 * Input: 4
 * Output: "1211"
 * @Author:      alex
 * @CreateDate:  2019/1/22 13:42
 * @param
 * @return
*/
public class CountAndSay {
    public static void main(String[] args) {
        System.out.println(countAndSay(4));
    }
    public static String countAndSay(int n){
        if (n==1) {
            return "1";
        }
        int count=0;
        String preString =countAndSay(n-1);
        StringBuilder stringBuilder=new StringBuilder();
        char s=preString.charAt(0);
        int countChar=0;
        while (count<preString.length()){
            char s1=preString.charAt(count);
            if (s==s1){
                countChar++;
                count++;
            }else{
                stringBuilder.append(countChar).append(s);
                countChar=0;
                s=s1;
            }
        }
        stringBuilder.append(countChar).append(s);
        return stringBuilder.toString();
    }
}
