/**
 * @Description:
 * @Author:      alex
 * @CreateDate:  2019/2/13 13:55
 * @param
 * @return
 */
public class Judge1BitAnd2BitCharacters {
    public static void main(String[] args) {
        int[] bits = {};
        System.out.println(isOneBitCharacter(bits));
    }

    public static boolean isOneBitCharacter(int[] bits) {
        int i = 0;
        while (i < bits.length - 1) {
            if (bits[i] == 0) {
                i++;
            } else {
                i += 2;
            }
        }
        return i==bits.length-1;
    }
}
