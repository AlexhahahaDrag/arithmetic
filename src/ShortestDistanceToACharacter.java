/**
 * @Description: Given a string S and a character C, return an array of integers representing the shortest distance from the character C in the string.
 *
 * Example 1:
 *
 * Input: S = "loveleetcode", C = 'e'
 * Output: [3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0]
 *
 *
 * Note:
 *
 * S string length is in [1, 10000].
 * C is a single character, and guaranteed to be in string S.
 * All letters in S and C are lowercase.
 * @Author:      alex
 * @CreateDate:  2019/2/14 10:09
 * @param
 * @return
 */
public class ShortestDistanceToACharacter {
    public static void main(String[] args) {
        int[] nums=shortestToChar("loveleetcode",'e');
        for (int i:
                nums) {
            System.out.print(i+ " ");
        }
    }
    public static int[] shortestToChar(String S, char C) {
        int index=0;
        int len=S.length();
        int[] nums=new int[len];
        int charIndex=S.indexOf(C);
        if (charIndex==-1) {
            return nums;
        }
        while(index<len) {
            int charIndex1 = S.indexOf(C, charIndex + 1);
            if (charIndex1!=-1&&Math.abs(charIndex-index)>Math.abs(charIndex1-index)) {
                charIndex=charIndex1;
            }
            nums[index]=Math.abs(charIndex-index++);
        }
        return nums;
    }

}
