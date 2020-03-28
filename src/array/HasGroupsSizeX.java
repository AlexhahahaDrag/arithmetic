package array;

/**
 *description:
 * 914. 卡牌分组
 * 给定一副牌，每张牌上都写着一个整数。
 *
 * 此时，你需要选定一个数字 X，使我们可以将整副牌按下述规则分成 1 组或更多组：
 *
 * 每组都有 X 张牌。
 * 组内所有的牌上都写着相同的整数。
 * 仅当你可选的 X >= 2 时返回 true。
 *
 *
 *
 * 示例 1：
 *
 * 输入：[1,2,3,4,4,3,2,1]
 * 输出：true
 * 解释：可行的分组是 [1,1]，[2,2]，[3,3]，[4,4]
 * 示例 2：
 *
 * 输入：[1,1,1,2,2,2,3,3]
 * 输出：false
 * 解释：没有满足要求的分组。
 * 示例 3：
 *
 * 输入：[1]
 * 输出：false
 * 解释：没有满足要求的分组。
 * 示例 4：
 *
 * 输入：[1,1]
 * 输出：true
 * 解释：可行的分组是 [1,1]
 * 示例 5：
 *
 * 输入：[1,1,2,2,2,2]
 * 输出：true
 * 解释：可行的分组是 [1,1]，[2,2]，[2,2]
 *
 * 提示：
 *
 * 1 <= deck.length <= 10000
 * 0 <= deck[i] < 10000
 *author:       alex
 *createDate:  2020/3/27 20:23
 *version:      1.0.0      
*/
public class HasGroupsSizeX {

    public boolean hasGroupsSizeX(int[] deck) {
        if(deck == null || deck.length < 2)
            return false;
        int[] map = new int[10001];
        for(int i : deck)
            map[i]++;
        int cur = 0;
        for(int j : map) {
            if(j == 0)
                continue;
            if (cur == 0)
                cur = j;
            else {
                cur = gcd(cur, j);
            }
        }
        return cur > 1;
    }

    private int gcd(int i, int j) {
        return j == 0 ? i : gcd(j, i % j);
    }

    public static void main(String[] args) {

        int[] arr = {1, 1, 1, 1, 1, 0, 0, 0};
        HasGroupsSizeX hasGroupsSizeX = new HasGroupsSizeX();
        System.out.println(hasGroupsSizeX.hasGroupsSizeX(arr));
    }
}
