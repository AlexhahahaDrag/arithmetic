package string;

/**
 *description:
 * 423. 从英文中重建数字
 * 给你一个字符串 s ，其中包含字母顺序打乱的用英文单词表示的若干数字（0-9）。按 升序 返回原始的数字。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "owoztneoer"
 * 输出："012"
 * 示例 2：
 *
 * 输入：s = "fviefuro"
 * 输出："45"
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 105
 * s[i] 为 ["e","g","f","i","h","o","n","s","r","u","t","w","v","x","z"] 这些字符之一
 * s 保证是一个符合题目要求的字符串
 *author:       alex
 *createDate:   2021/11/24 14:39
 *version:      1.0.0
 */
public class OriginalDigits {

    public String originalDigits(String s) {
        int[] res = new int[10];
        char[] ch = s.toCharArray();
        int[] map = new int[26];
        for(char c : ch) {
            map[c - 'a']++;
        }
        //0,2,4,6,8是包含唯一的字母
        if (map['z' - 'a'] > 0) {
            res[0] = map['z' - 'a'];
            map['o' - 'a'] -= map['z' - 'a'];
        }
        if (map['w' - 'a'] > 0) {
            res[2] = map['w' - 'a'];
            map['o' - 'a'] -= map['w' - 'a'];
        }
        if (map['u' - 'a'] > 0) {
            res[4] = map['u' - 'a'];
            map['f' - 'a'] -= map['u' - 'a'];
            map['o' - 'a'] -= map['u' - 'a'];
        }
        if (map['x' - 'a'] > 0) {
            res[6] = map['x' - 'a'];
            map['s' - 'a'] -= map['x' - 'a'];
        }
        if (map['g' - 'a'] > 0) {
            res[8] = map['g' - 'a'];
            map['h' - 'a'] -= map['g' - 'a'];
            map['t' - 'a'] -= map['g' - 'a'];
        }
        //1,3,5,7,9也包含唯一的字母了
        if (map['o' - 'a'] > 0) {
            res[1] = map['o' - 'a'];
            map['n' - 'a'] -= map['o' - 'a'];
        }
        if (map['h' - 'a'] > 0) {
            res[3] = map['h' - 'a'];
        }
        if (map['f' - 'a'] > 0) {
            res[5] = map['f' - 'a'];
        }
        if (map['s' - 'a'] > 0) {
            res[7] = map['s' - 'a'];
            map['n' - 'a'] -= map['s' - 'a'];
        }
        if (map['n' - 'a'] > 0) {
            res[9] = map['n' - 'a'] >> 1;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            while (res[i]-- > 0) {
                sb.append(i);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
//        String[] nums = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        String[] nums = { "one",  "three", "five", "seven",  "nine"};
        int[] res = new int[26];
        for(String num : nums) {
            for(char c : num.toCharArray()) {
                res[c - 'a']++;
            }
        }
        for (int i = 0; i < res.length; i++) {
            if (res[i] == 1) {
                System.out.print((char)(i + 'a') + " ");
            }
        }
    }
}
