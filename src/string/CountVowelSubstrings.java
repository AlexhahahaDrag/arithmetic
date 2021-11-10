package string;

/**
 *description:
 * 2062. 统计字符串中的元音子字符串
 * 子字符串 是字符串中的一个连续（非空）的字符序列。
 *
 * 元音子字符串 是 仅 由元音（'a'、'e'、'i'、'o' 和 'u'）组成的一个子字符串，且必须包含 全部五种 元音。
 *
 * 给你一个字符串 word ，统计并返回 word 中 元音子字符串的数目 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：word = "aeiouu"
 * 输出：2
 * 解释：下面列出 word 中的元音子字符串（斜体加粗部分）：
 * - "aeiouu"
 * - "aeiouu"
 * 示例 2：
 *
 * 输入：word = "unicornarihan"
 * 输出：0
 * 解释：word 中不含 5 种元音，所以也不会存在元音子字符串。
 * 示例 3：
 *
 * 输入：word = "cuaieuouac"
 * 输出：7
 * 解释：下面列出 word 中的元音子字符串（斜体加粗部分）：
 * - "cuaieuouac"
 * - "cuaieuouac"
 * - "cuaieuouac"
 * - "cuaieuouac"
 * - "cuaieuouac"
 * - "cuaieuouac"
 * - "cuaieuouac"
 * 示例 4：
 *
 * 输入：word = "bbaeixoubb"
 * 输出：0
 * 解释：所有包含全部五种元音的子字符串都含有辅音，所以不存在元音子字符串。
 *
 *
 * 提示：
 *
 * 1 <= word.length <= 100
 * word 仅由小写英文字母组成
 *author:       alex
 *createDate:   2021/11/8 20:44
 *version:      1.0.0
 */
public class CountVowelSubstrings {

    public int countVowelSubstrings(String word) {
        int[] map = new int[5];
        char[] ch = word.toCharArray();
        int start = 0;
        int res = 0;
        int cl;
        int num = 0;
        for (int i = 0; i < ch.length; i++) {

            switch (ch[i]) {
                case 'a':
                    map[0]++;
                    break;
                case 'e' :
                    map[1]++;
                    break;
                case 'i' :
                    map[2]++;
                    break;
                case 'o':
                    map[3]++;
                    break;
                case 'u':
                    map[4]++;
                    break;
            }
            if (map[0] > 0 && map[1] > 0 && map[2] > 0 && map[3] > 0 && map[4] > 0) {
                cl = ch.length - i - 1 == 0 ? 1 : ch.length - i - 1;
                res += cl;
                while(start < ch.length && map[0] > 0 && map[1] > 0 && map[2] > 0 && map[3] > 0 && map[4] > 0) {
                    switch (ch[start]) {
                        case 'a':
                            map[0]--;
                            break;
                        case 'e' :
                            map[1]--;
                            break;
                        case 'i' :
                            map[2]--;
                            break;
                        case 'o':
                            map[3]--;
                            break;
                        case 'u':
                            map[4]--;
                            break;
                    }
                    start++;

                }

            }
        }
        return res;
    }

    public static void main(String[] args) {
        String word = "cuaieuouac";
        CountVowelSubstrings countVowelSubstrings = new CountVowelSubstrings();
        System.out.println(countVowelSubstrings.countVowelSubstrings(word));
    }
}
