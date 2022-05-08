package string;

/**
 *description:
 * 6058. 统计打字方案数
 * Alice 在给 Bob 用手机打字。数字到字母的 对应 如下图所示。
 *
 *
 *
 * 为了 打出 一个字母，Alice 需要 按 对应字母 i 次，i 是该字母在这个按键上所处的位置。
 *
 * 比方说，为了按出字母 's' ，Alice 需要按 '7' 四次。类似的， Alice 需要按 '5' 两次得到字母  'k' 。
 * 注意，数字 '0' 和 '1' 不映射到任何字母，所以 Alice 不 使用它们。
 * 但是，由于传输的错误，Bob 没有收到 Alice 打字的字母信息，反而收到了 按键的字符串信息 。
 *
 * 比方说，Alice 发出的信息为 "bob" ，Bob 将收到字符串 "2266622" 。
 * 给你一个字符串 pressedKeys ，表示 Bob 收到的字符串，请你返回 Alice 总共可能发出多少种文字信息 。
 *
 * 由于答案可能很大，将它对 109 + 7 取余 后返回。
 *
 *
 *
 * 示例 1：
 *
 * 输入：pressedKeys = "22233"
 * 输出：8
 * 解释：
 * Alice 可能发出的文字信息包括：
 * "aaadd", "abdd", "badd", "cdd", "aaae", "abe", "bae" 和 "ce" 。
 * 由于总共有 8 种可能的信息，所以我们返回 8 。
 * 示例 2：
 *
 * 输入：pressedKeys = "222222222222222222222222222222222222"
 * 输出：82876089
 * 解释：
 * 总共有 2082876103 种 Alice 可能发出的文字信息。
 * 由于我们需要将答案对 109 + 7 取余，所以我们返回 2082876103 % (109 + 7) = 82876089 。
 *
 *
 * 提示：
 *
 * 1 <= pressedKeys.length <= 105
 * pressedKeys 只包含数字 '2' 到 '9' 。
 *author:       alex
 *createDate:   2022/5/8 11:10
 *version:      1.0.0
 */
public class CountTexts {

    public int countTexts(String p) {
        int mod = (int)Math.pow(10, 9) + 7;
        long[] four = new long[100001];
        long[] three = new long[100001];
        four[0] = 1;
        four[1] = 1;
        four[2] = 2;
        four[3] = 4;
        three[0] = 1;
        three[1] = 1;
        three[2] = 2;
        three[3] = 4;
        for(int i = 4; i < 100001; i++) {
            three[i] = (three[i - 1] + three[i - 2] + three[i - 3]) % mod;
            four[i] = (four[i - 1] + four[i - 2] + four[i - 3] + four[i - 4]) % mod;
        }
        long res = 1;
        int len = p.length();
        int i = 0;
        int n = 1;
        char pre = p.charAt(0);
        long cur;
        while(++i < len) {
            if(p.charAt(i) == pre) {
                n++;
            } else {
                if(pre == '7' || pre == '9') {
                    cur = four[n];
                } else {
                    cur = three[n];
                }
                res = res * cur % mod;
                n = 1;
                pre= p.charAt(i);
            }
        }
        if(pre == '7' || pre == '9') {
            cur = four[n];
        } else {
            cur = three[n];
        }
        res = res * cur % mod;
        return (int)res;
    }

    public static void main(String[] args) {
//        String p = "444479999555588866";//3136
//        String p = "222222222222222222222222222222222222";//82876089
//        String p = "355577777788899";//928
//        String p = "7777777";
//        String p ="444444444444444444444444444444448888888888888888999999999999333333333333333366666666666666662222222222222222666666666666666633333333333333338888888888888888222222222222222244444444444444448888888888888222222222222222288888888888889999999999999999333333333444444664";
        String  p = "444444444444444444444444444444448888888888888888999999999999";
        CountTexts countTexts = new CountTexts();
        System.out.println(countTexts.countTexts(p));
    }
}
