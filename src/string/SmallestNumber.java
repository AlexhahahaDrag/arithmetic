package string;

/**
 *@description:
 * 2375. 根据模式串构造最小数字
 * 给你下标从 0 开始、长度为 n 的字符串 pattern ，它包含两种字符，'I' 表示 上升 ，'D' 表示 下降 。
 *
 * 你需要构造一个下标从 0 开始长度为 n + 1 的字符串，且它要满足以下条件：
 *
 * num 包含数字 '1' 到 '9' ，其中每个数字 至多 使用一次。
 * 如果 pattern[i] == 'I' ，那么 num[i] < num[i + 1] 。
 * 如果 pattern[i] == 'D' ，那么 num[i] > num[i + 1] 。
 * 请你返回满足上述条件字典序 最小 的字符串 num。
 *
 *
 *
 * 示例 1：
 *
 * 输入：pattern = "IIIDIDDD"
 * 输出："123549876"
 * 解释：
 * 下标 0 ，1 ，2 和 4 处，我们需要使 num[i] < num[i+1] 。
 * 下标 3 ，5 ，6 和 7 处，我们需要使 num[i] > num[i+1] 。
 * 一些可能的 num 的值为 "245639871" ，"135749862" 和 "123849765" 。
 * "123549876" 是满足条件最小的数字。
 * 注意，"123414321" 不是可行解因为数字 '1' 使用次数超过 1 次。
 * 示例 2：
 *
 * 输入：pattern = "DDD"
 * 输出："4321"
 * 解释：
 * 一些可能的 num 的值为 "9876" ，"7321" 和 "8742" 。
 * "4321" 是满足条件最小的数字。
 *
 *
 * 提示：
 *
 * 1 <= pattern.length <= 8
 * pattern 只包含字符 'I' 和 'D' 。
 *@author:       alex
 *@createDate:   2022/8/16 23:03
 *@version:      1.0.0
 */
public class SmallestNumber {

    public String smallestNumber(String pattern) {
        boolean[] visited = new boolean[10];
        int len = pattern.length();
        int[] res = new int[len + 1];
        for(int i = 1; i < 10; i++) {
            res[0] = i;
            visited[i] = true;
            if (get(pattern, 0, visited, len, res)) {
                StringBuilder sb = new StringBuilder();
                for (int j : res) {
                    sb.append(j);
                }
                return sb.toString();
            }
            visited[i] = false;
        }
        return "";
    }

    private boolean get(String pattern, int i, boolean[] visited, int len, int[] res) {
        if (i >= len) {
            return true;
        }
        char ch = pattern.charAt(i);
        if(ch == 'I') {
            for(int num = 1; num < 10; num++) {
                if (num > res[i] && !visited[num]) {
                    res[i + 1] = num;
                    visited[num] = true;
                    if (get(pattern, i + 1, visited, len, res) ) {
                        return true;
                    }
                    visited[num] = false;
                }
            }
        } else {
            for(int num = 1; num < 10; num++) {
                if (num < res[i] && !visited[num]) {
                    res[i + 1] = num;
                    visited[num] = true;
                    if (get(pattern, i + 1, visited, len, res) ) {
                        return true;
                    }
                    visited[num] = false;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
//        String pettern = "IIIDIDDD";//123549876
        String pettern = "DDD";//4321
        SmallestNumber smallestNumber = new SmallestNumber();
        System.out.println(smallestNumber.smallestNumber(pettern));
    }
}
