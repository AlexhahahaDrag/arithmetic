package string_array;

/**
 *description:
 * 1366. 通过投票对团队排名 显示英文描述
 * 用户通过次数879
 * 用户尝试次数1320
 * 通过次数892
 * 提交次数2497
 * 题目难度Medium
 * 现在有一个特殊的排名系统，依据参赛团队在投票人心中的次序进行排名，每个投票者都需要按从高到低的顺序对参与排名的所有团队进行排位。
 *
 * 排名规则如下：
 *
 * 参赛团队的排名次序依照其所获「排位第一」的票的多少决定。如果存在多个团队并列的情况，将继续考虑其「排位第二」的票的数量。以此类推，直到不再存在并列的情况。
 * 如果在考虑完所有投票情况后仍然出现并列现象，则根据团队字母的字母顺序进行排名。
 * 给你一个字符串数组 votes 代表全体投票者给出的排位情况，请你根据上述排名规则对所有参赛团队进行排名。
 *
 * 请你返回能表示按排名系统 排序后 的所有团队排名的字符串。
 *
 *
 *
 * 示例 1：
 *
 * 输入：votes = ["ABC","ACB","ABC","ACB","ACB"]
 * 输出："ACB"
 * 解释：A 队获得五票「排位第一」，没有其他队获得「排位第一」，所以 A 队排名第一。
 * B 队获得两票「排位第二」，三票「排位第三」。
 * C 队获得三票「排位第二」，两票「排位第三」。
 * 由于 C 队「排位第二」的票数较多，所以 C 队排第二，B 队排第三。
 * 示例 2：
 *
 * 输入：votes = ["WXYZ","XYZW"]
 * 输出："XWYZ"
 * 解释：X 队在并列僵局打破后成为排名第一的团队。X 队和 W 队的「排位第一」票数一样，但是 X 队有一票「排位第二」，而 W 没有获得「排位第二」。
 * 示例 3：
 *
 * 输入：votes = ["ZMNAGUEDSJYLBOPHRQICWFXTVK"]
 * 输出："ZMNAGUEDSJYLBOPHRQICWFXTVK"
 * 解释：只有一个投票者，所以排名完全按照他的意愿。
 * 示例 4：
 *
 * 输入：votes = ["BCA","CAB","CBA","ABC","ACB","BAC"]
 * 输出："ABC"
 * 解释：
 * A 队获得两票「排位第一」，两票「排位第二」，两票「排位第三」。
 * B 队获得两票「排位第一」，两票「排位第二」，两票「排位第三」。
 * C 队获得两票「排位第一」，两票「排位第二」，两票「排位第三」。
 * 完全并列，所以我们需要按照字母升序排名。
 * 示例 5：
 *
 * 输入：votes = ["M","M","M","M"]
 * 输出："M"
 * 解释：只有 M 队参赛，所以它排名第一。
 *
 *
 * 提示：
 *
 * 1 <= votes.length <= 1000
 * 1 <= votes[i].length <= 26
 * votes[i].length == votes[j].length for 0 <= i, j < votes.length
 * votes[i][j] 是英文 大写 字母
 * votes[i] 中的所有字母都是唯一的
 * votes[0] 中出现的所有字母 同样也 出现在 votes[j] 中，其中 1 <= j < votes.length
 *author:       alex
 *createDate:  2020/3/3 17:56
 *version:      1.0.0
*/
public class RankTeams {
    int size = 0;
    public String rankTeams(String[] votes) {
        if (votes == null || votes.length < 1)
            return null;
        int[][] map = new int[votes[0].length()][votes[0].length()];
        char[] index = new char[votes[0].length()];
        for (String vote : votes) {
            int in = 0;
            int len = vote.length();
            while(in < len) {
                char c = vote.charAt(in);
                int inc = findChar(index, c);
                map[in++][inc]++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < index.length; i++) {
            int max = 0;
            while(index[max] == ' ')
                max++;
            for (int j = max + 1; j < index.length; j++) {
                if (index[j] == ' ')
                    continue;
                if (findRes(map, index, j, max, 0)) {
                    max = j;
                }
            }
            sb.append(index[max]);
            index[max] = ' ';
        }
        return sb.toString();
    }

    private boolean findRes(int[][] map, char[] res, int in1, int in2, int index) {
        if (index == map[0].length)
            return res[in1] < res[in2];
        if (map[index][in1] > map[index][in2])
            return true;
        else if (map[index][in1] < map[index][in2])
            return false;
        return findRes(map, res, in1, in2, ++index);
    }

    private int findChar(char[] ch, char c) {
        for (int i = 0; i < size; i++) {
            if (ch[i] == c)
                return i;
        }
        ch[size] = c;
        return size++;
    }

    public static void main(String[] args) {
        String[] votes = {"ABC","ACB","ABC","ACB","ACB"};
        RankTeams rankTeams = new RankTeams();
        System.out.println(rankTeams.rankTeams(votes));
    }
}
