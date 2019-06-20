package string;
/**
 * @Description: 已知一个字符串s= "findinahedleaysnaedletackneedleina";
 *                         求t="needle"在他中的位置
 * @Author:     alex
 * @CreateDate: 2019/6/20 17:40
 * @Version:    1.0
 *
*/
public class BMArgorithm {
    public static void main(String[] args) {
        BMArgorithm bmArgorithm = new BMArgorithm();
        String s = "findinahedleaysnaedletackneedleina";
        String t = "abcabcaaabc";
        bmArgorithm.getNext(t);
    }
    public int getBM(String res, String tar) {
        char[] resChar = res.toCharArray();
        char[] tarChar = tar.toCharArray();
        int start = tarChar.length - 1;
        int moveIndex = tarChar.length - 1;
        int index;
        int move;
        while(moveIndex < resChar.length) {
            index = moveIndex;
            while (resChar[index] == tarChar[start])
                index--;start--;
            if (start == -1)
                return index + 1;

            moveIndex += Math.max(1,1);
        }
        return 1;
    }
    public int[] getNext(String str) {
        char[] chars = str.toCharArray();
        int[] next = new int[chars.length];
        int j = 0;
        int k = -1;
        while(j < chars.length) {
            if (k == -1 || chars[k] == chars[j]) {
                next[j] = k++;
                j++;
            } else
                k = next[k];
        }
        return next;
    }
}
