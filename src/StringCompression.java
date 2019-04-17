/**
 * @Description: Given an array of characters, compress it in-place.
 *
 * The length after compression must always be smaller than or equal to the original array.
 *
 * Every element of the array should be a character (not int) of length 1.
 *
 * After you are done modifying the input array in-place, return the new length of the array.
 *
 *
 * Follow up:
 * Could you solve it using only O(1) extra space?
 *
 *
 * Example 1:
 *
 * Input:
 * ['a','a','b','b','c','c','c']
 *
 * Output:
 * Return 6, and the first 6 characters of the input array should be: ['a','2','b','2','c','3']
 *
 * Explanation:
 * 'aa' is replaced by 'a2'. 'bb' is replaced by 'b2'. 'ccc' is replaced by 'c3'.
 *
 *
 * Example 2:
 *
 * Input:
 * ['a']
 *
 * Output:
 * Return 1, and the first 1 characters of the input array should be: ['a']
 *
 * Explanation:
 * Nothing is replaced.
 *
 *
 * Example 3:
 *
 * Input:
 * ['a','b','b','b','b','b','b','b','b','b','b','b','b']
 *
 * Output:
 * Return 4, and the first 4 characters of the input array should be: ['a','b','1','2'].
 *
 * Explanation:
 * Since the character 'a' does not repeat, it is not compressed. 'bbbbbbbbbbbb' is replaced by 'b12'.
 * Notice each digit has it's own entry in the array.
 *
 *
 * Note:
 *
 * All characters have an ASCII value in [35, 126].
 * 1 <= len(chars) <= 1000.
 *
 * Explanation:
 * Nothing is replaced.
 * @Author:      alex
 * @CreateDate:  2019/1/22 14:29
 * @param
 * @return
 */
public class StringCompression {
    public static void main(String[] args) {
        char[] chars={'a','b','b','b','b','b','b','b','b','b','b','b','b'};
        System.out.println(compress(chars));
    }
    public static int compress(char[] chars) {
        int countChar=0;
        int count=0;
        int countIndex=0;
        while(countIndex<chars.length){
            char t=chars[countIndex];
            while (countIndex<chars.length&&t==chars[countIndex]){
                count++;
                countIndex++;
            }
            chars[countChar++]=t;
            if (count>1&&count<10)
                chars[countChar++]=(char)(count+'0');
            else if (count>=10){
                char[] chars1=(count+"").toCharArray();
                for (int i = 0; i < chars1.length; i++)
                    chars[countChar++]=chars1[i];
            }
            count=0;
        }
        return countChar;
    }
    public static int compress1(char[] chars){
        int count=0;
        char t=chars[0];
        StringBuilder stringBuilder=new StringBuilder();
        for (int i = 0; i < chars.length;) {
            if (t==chars[i]){
                count++;
                i++;
            }else {
                stringBuilder.append(t);
                if (count!=1){
                    stringBuilder.append(count);
                }
                count=0;
                t=chars[i];
            }
        }
        stringBuilder.append(t);
        if (count!=1){
            stringBuilder.append(count);
        }
        chars=stringBuilder.toString().toCharArray();
        return chars.length;
    }
}
