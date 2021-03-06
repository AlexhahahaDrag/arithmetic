/**
 * Given two strings s and t which consist of only lowercase letters.
 *
 * String t is generated by random shuffling string s and then add one more letter at a random position.
 *
 * Find the letter that was added in t.
 *
 * Example:
 *
 * Input:
 * s = "abcd"
 * t = "abcde"
 *
 * Output:
 * e
 *
 * Explanation:
 * 'e' is the letter that was added.
 */
public class FindTheDifference {
    public static void main(String[] args) {
        System.out.println(findTheDifferenceMehtod("abcd","abcde"));
    }
    public static char findTheDifferenceMehtod(String s,String t){
        byte[] ss=s.getBytes();
        byte[] tt=t.getBytes();
        int dif=0;
        for(int i=0;i<ss.length;i++){
            dif=dif^ss[i]^tt[i];
        }
        dif=dif^tt[tt.length-1];
        return (char) dif;
    }
}
