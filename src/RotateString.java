/**
 * @Description: We are given two strings, A and B.
 *
 * A shift on A consists of taking string A and moving the leftmost character to the rightmost position. For example, if A = 'abcde', then it will be 'bcdea' after one shift on A. Return True if and only if A can become B after some number of shifts on A.
 *
 * Example 1:
 * Input: A = 'abcde', B = 'cdeab'
 * Output: true
 *
 * Example 2:
 * Input: A = 'abcde', B = 'abced'
 * Output: false
 * Note:
 *
 *
 * "ohbrwzxvxe"
 * "uornhegseo"
 *
 * "vcuszhlbtpmksjleuchmjffufrwpiddgyynfujnqblngzoogzg"
 * "fufrwpiddgyynfujnqblngzoogzgvcuszhlbtpmksjleuchmjf"
 *
 * A and B will have length at most 100.
 * @Author:      alex
 * @CreateDate:  2019/2/14 9:38
 * @param
 * @return
*/
public class RotateString {
    public static void main(String[] args) {
        System.out.println(rotateString("fufrwpiddgyynfujnqblngzoogzgvcuszhlbtpmksjleuchmjf","fufrwpiddgyynfujnqblngzoogzgvcuszhlbtpmksjleuchmjf"));
    }
    public static boolean rotateString(String A, String B) {
       if (A.length()!=B.length())
           return false;
       else if (A.length()==0)
           return true;
        int index=0;
        while(index<A.length()){
            while(index<A.length()&&A.charAt(index)!=B.charAt(0))
                index++;
            System.out.println(B.length()-index);
            System.out.println(index-1);
            if (B.substring(0,B.length()-index).equals(A.substring(index))&&(
                    B.substring(B.length()-index).equals(A.substring(0,index))))
                return true;
            index++;
        }
        return false;
    }
}
