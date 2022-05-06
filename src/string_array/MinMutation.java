package string_array;

import java.util.LinkedList;
import java.util.Queue;

/**
 *description:
 433. 最小基因变化
 基因序列可以表示为一条由 8 个字符组成的字符串，其中每个字符都是 'A'、'C'、'G' 和 'T' 之一。

 假设我们需要调查从基因序列 start 变为 end 所发生的基因变化。一次基因变化就意味着这个基因序列中的一个字符发生了变化。

 例如，"AACCGGTT" --> "AACCGGTA" 就是一次基因变化。
 另有一个基因库 bank 记录了所有有效的基因变化，只有基因库中的基因才是有效的基因序列。

 给你两个基因序列 start 和 end ，以及一个基因库 bank ，请你找出并返回能够使 start 变化为 end 所需的最少变化次数。如果无法完成此基因变化，返回 -1 。

 注意：起始基因序列 start 默认是有效的，但是它并不一定会出现在基因库中。



 示例 1：

 输入：start = "AACCGGTT", end = "AACCGGTA", bank = ["AACCGGTA"]
 输出：1
 示例 2：

 输入：start = "AACCGGTT", end = "AAACGGTA", bank = ["AACCGGTA","AACCGCTA","AAACGGTA"]
 输出：2
 示例 3：

 输入：start = "AAAAACCC", end = "AACCCCCC", bank = ["AAAACCCC","AAACCCCC","AACCCCCC"]
 输出：3


 提示：

 start.length == 8
 end.length == 8
 0 <= bank.length <= 10
 bank[i].length == 8
 start、end 和 bank[i] 仅由字符 ['A', 'C', 'G', 'T']  *author:       alex
 *createDate:   2022/5/7 6:20
 *version:      1.0.0
 */
public class MinMutation {

    public int minMutation(String start, String end, String[] bank) {
        Queue<String> queue = new LinkedList<>();
        queue.add(start);
        boolean[] map = new boolean[bank.length];
        String cur;
        int size;
        int res = 1;
        //bfs
        while(!queue.isEmpty()) {
            size = queue.size();
            while(--size >= 0) {
                cur = queue.poll();
                for(int i = 0; i < bank.length; i++) {
                    //没有被访问过，并且和当前字符串相差一个字符
                    if (!map[i] && judge(cur, bank[i])) {
                        //如果被查字符与end字符相等，则返回当前查找次数
                        if (bank[i].equals(end)) {
                            return res;
                        } else {
                            //否则加入到队列中进行下一次查找
                            queue.add(bank[i]);
                            map[i] = true;
                        }
                    }
                }
            }
            res++;
        }
        return -1;
    }

    private boolean judge(String str1, String str2) {
        int i = -1;
        int dif = 0;
        while(++i < 8) {
            if (str1.charAt(i) != str2.charAt(i)) {
                dif++;
            }
        }
        return dif == 1;
    }

    public static void main(String[] args) {
        String start ="AAAAACCC" ;
        String end = "AACCCCCC";
        String[] bank = {"AAAACCCC","AAACCCCC","AACCCCCC"};
        MinMutation minMutation = new MinMutation();
        System.out.println(minMutation.minMutation(start, end, bank));
    }
}
