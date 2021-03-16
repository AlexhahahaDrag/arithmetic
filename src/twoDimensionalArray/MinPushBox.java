package twoDimensionalArray;

import array.MaxSumDivThree;

import java.util.Stack;

/**
 * @Description:
 *「推箱子」是一款风靡全球的益智小游戏，玩家需要将箱子推到仓库中的目标位置。
 *
 * 游戏地图用大小为 n * m 的网格 grid 表示，其中每个元素可以是墙、地板或者是箱子。
 *
 * 现在你将作为玩家参与游戏，按规则将箱子 'B' 移动到目标位置 'T' ：
 *
 * 玩家用字符 'S' 表示，只要他在地板上，就可以在网格中向上、下、左、右四个方向移动。
 * 地板用字符 '.' 表示，意味着可以自由行走。
 * 墙用字符 '#' 表示，意味着障碍物，不能通行。 
 * 箱子仅有一个，用字符 'B' 表示。相应地，网格上有一个目标位置 'T'。
 * 玩家需要站在箱子旁边，然后沿着箱子的方向进行移动，此时箱子会被移动到相邻的地板单元格。记作一次「推动」。
 * 玩家无法越过箱子。
 * 返回将箱子推到目标位置的最小 推动 次数，如果无法做到，请返回 -1。
 * 示例 1：
 * 输入：grid = [['#','#','#','#','#','#'],
 *              ['#','T','#','#','#','#'],
 *              ['#','.','.','B','.','#'],
 *              ['#','.','#','#','.','#'],
 *              ['#','.','.','.','S','#'],
 *              ['#','#','#','#','#','#']]
 * 输出：3
 * 解释：我们只需要返回推箱子的次数。
 * 示例 2：
 * 输入：grid = [['#','#','#','#','#','#'],
 *              ['#','T','#','#','#','#'],
 *              ['#','.','.','B','.','#'],
 *              ['#','#','#','#','.','#'],
 *              ['#','.','.','.','S','#'],
 *              ['#','#','#','#','#','#']]
 * 输出：-1
 * 示例 3：
 * 输入：grid = [['#','#','#','#','#','#'],
 *              ['#','T','.','.','#','#'],
 *              ['#','.','#','B','.','#'],
 *              ['#','.','.','.','.','#'],
 *              ['#','.','.','.','S','#'],
 *              ['#','#','#','#','#','#']]
 * 输出：5
 * 解释：向下、向左、向左、向上再向上。
 * 示例 4：
 *
 * 输入：grid = [['#','#','#','#','#','#','#'],
 *              ['#','S','#','.','B','T','#'],
 *              ['#','#','#','#','#','#','#']]
 * 输出：-1
 * 提示：
 * 1 <= grid.length <= 20
 * 1 <= grid[i].length <= 20
 * grid 仅包含字符 '.', '#',  'S' , 'T', 以及 'B'。
 * grid 中 'S', 'B' 和 'T' 各只能出现一个。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-moves-to-move-a-box-to-their-target-location
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author:     alex
 * @CreateDate: 2019/11/18 11:42
 * @Version:    1.0
 *
*/
public class MinPushBox {

    int step = 0;
    public static void main(String[] args) {
        char[][] grid = {{'#','#','#','#','#','#'}, {'#','T','.','.','#','#'}, {'#','.','#','B','.','#'}, {'#','.','.','.','.','#'}, {'#','.','.','.','S','#'}, {'#','#','#','#','#','#'}};
        MinPushBox minPushBox = new MinPushBox();
        System.out.println(minPushBox.minPushBox(grid));
    }

    public int minPushBox(char[][] grid) {
        Stack<Integer[]> stack = new Stack<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 'B') {
                    stack.add(new Integer[]{i, j});
                }
            }
        }
                if (find(grid, stack)) {
                    return step;
                } else {
                    return -1;
                }
    }

    private boolean find(char[][] grid, Stack<Integer[]> stack) {
        int x = grid.length;
        int y = grid[0].length;
        while(stack.size() > 0) {
            Stack<Integer[]> nextStack = new Stack<>();
            while(stack.size() > 0) {
                Integer[] index = stack.pop();
                char ch = grid[index[0]][index[1]];
                if (ch == 'T') {
                    return true;
                } else if (ch == '#') {
                    continue;
                }
                move(nextStack, index, x, y);
            }
            step++;
            stack = nextStack;
        }
        return false;
    }
    private void move(Stack<Integer[]> nextStack, Integer[] mo, int x, int y) {
        if (mo[0] - 1 >= 0) {
            nextStack.add(new Integer[]{mo[0] - 1, mo[1]});
        }
        if (mo[0] + 1 < x) {
            nextStack.add(new Integer[]{mo[0] + 1, mo[1]});
        }
        if (mo[1] - 1 >= 0) {
            nextStack.add(new Integer[]{mo[0], mo[1] - 1});
        }
        if (mo[1] + 1 < y) {
            nextStack.add(new Integer[]{mo[0], mo[1] + 1});
        }
    }
}
