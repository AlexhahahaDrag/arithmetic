package twoDimensionalArray;

import java.util.*;

public class CutOffTree {

    private int m;
    private int n;
    private int[] next = new int[2];
    private int step;
    private int minims;

    public int cutOffTree1(List<List<Integer>> forest) {
        m = forest.size();
        n = forest.get(0).size();

        int[][] map = new  int[m][n];
        int need = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int cur = forest.get(i).get(j);
                if(cur > 1) {
                    need++;
                }
                map[i][j] = cur;
            }
        }
        int res = 0;
        minims = Integer.MAX_VALUE;
        int pre = minims;
        while(need > 0) {
            find(map, next[0], next[1]);
            if (minims == pre) {
                return -1;
            }
            pre = minims;
            res += step;
            map[next[0]][next[1]] = 1;
            need--;
        }
        return res;
    }

    private void find(int[][] map, int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visit = new boolean[m][n];
        queue.add(new int[]{i, j});

        int min = Integer.MAX_VALUE;
        int num = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            int ind = 0;
            while(ind++ < size) {
                int[] cur = queue.poll();
                int ii = cur[0];
                int jj = cur[1];
                visit[ii][jj] = true;
                if (map[ii][jj] > 1) {
                    if (min > map[ii][jj]) {
                        step = num;
                        next = new int[] {ii, jj};
                        min = map[ii][jj];
                        minims = min;
                    }
                }
                if (ii - 1 >= 0 && !visit[ii - 1][jj] && map[ii - 1][jj] > 0) {
                    queue.add(new int[] {ii - 1, jj});
                }
                if(ii +1 < m  && !visit[ii + 1][jj] && map[ii + 1][jj] > 0) {
                    queue.add(new int[] {ii + 1, jj});
                }

                if (jj + 1 < n  && !visit[ii][jj + 1] && map[ii][jj + 1] > 0) {
                    queue.add(new int[] {ii, jj + 1});
                }
                if (jj - 1 >= 0  && !visit[ii][jj - 1] && map[ii][jj - 1] > 0) {
                    queue.add(new int[] {ii, jj - 1});
                }
            }
            num++;
        }
    }

    public int cutOffTree(List<List<Integer>> forest) {
        List<int[]> trees = new ArrayList<>();
        int mm = forest.size();
        int nn = forest.get(0).size();
        for (int i = 0; i < mm; i++) {
            for (int j = 0; j < nn; j++) {
                int val = forest.get(i).get(j);
                if (val > 1) {
                    trees.add(new int[]{i, j, val});
                }
            }
        }
        trees.sort(Comparator.comparingInt(o -> o[2]));
        int sx = 0;
        int sy = 0;
        int res = 0;
        int dx;
        int dy;
        for (int[] tree : trees) {
            dx = tree[0];
            dy = tree[1];
            int step = bfs(forest, sx, sy, dx, dy);
            if (step == -1) {
                return -1;
            }
            sx = dx;
            sy = dy;
            res += step;
        }
        return res;
    }

    private int[][] dic = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    private int bfs(List<List<Integer>> forest, int sx, int sy, int dx, int dy) {
        if (sx == dx && sy == dy) {
            return 0;
        }
        int step = 0;
        int row = forest.size();
        int col = forest.get(0).size();
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[row][col];
        queue.offer(new int[]{sx, sy});
        visited[sx][sy] = true;
        while(!queue.isEmpty()) {
            step++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();

                for (int j = 0; j < 4; j++) {
                    int nx = cur[0] + dic[j][0];
                    int ny = cur[1] + dic[j][1];
                    if (nx >= 0 && nx <row && ny >= 0 && ny < col) {
                        if (visited[nx][ny] || forest.get(nx).get(ny) == 0) {
                            continue;
                        }
                        if (nx == dx && ny == dy) {
                            return step;
                        }
                        queue.add(new int[]{nx, ny});
                        visited[nx][ny] = true;
                    }
                }
            }
        }
        return -1;
    }



    public static void main(String[] args) {
//        Integer[][] arr = {{1,2 ,3}, {0, 0, 4}, {5, 6, 7}};//8
//        Integer[][] arr = {{1,2 ,3}, {0, 0, 0}, {5, 6, 7}};//-1
//        Integer[][] arr = {{2,3,4}, {0, 0,5}, {8,7,6}};//6
//        Integer[][] arr = {{54581641,64080174,24346381,69107959},
//                {86374198,61363882,68783324,79706116},
//                {668150,92178815,89819108,94701471},
//                {83920491,22724204,46281641,47531096},
//                {89078499,18904913,25462145,60813308}};//57
        Integer[][] arr = {{1}, {0}, {0}};//0
//        Integer[][] arr = {{69438,55243,0,43779,5241,93591,73380},{847,49990,53242,21837,89404,63929,48214},{90332,49751,0,3088,16374,70121,25385},{14694,4338,87873,86281,5204,84169,5024},{31711,47313,1885,28332,11646,42583,31460},{59845,94855,29286,53221,9803,41305,60749},{95077,50343,27947,92852,0,0,19731},{86158,63553,56822,90251,0,23826,17478},{60387,23279,78048,78835,5310,99720,0},{74799,48845,60658,29773,96129,90443,14391},{65448,63358,78089,93914,7931,68804,72633},{93431,90868,55280,30860,59354,62083,47669},{81064,93220,22386,22341,95485,20696,13436},{50083,0,89399,43882,0,13593,27847},{0,12256,33652,69301,73395,93440,0},{42818,87197,81249,33936,7027,5744,64710},{35843,0,99746,52442,17494,49407,63016},{86042,44524,0,0,26787,97651,28572},{54183,83466,96754,89861,84143,13413,72921},{89405,52305,39907,27366,14603,0,14104},{70909,61104,70236,30365,0,30944,98378},{20124,87188,6515,98319,78146,99325,88919},{89669,0,64218,85795,2449,48939,12869},{93539,28909,90973,77642,0,72170,98359},{88628,16422,80512,0,38651,50854,55768},{13639,2889,74835,80416,26051,78859,25721},{90182,23154,16586,0,27459,3272,84893},{2480,33654,87321,93272,93079,0,38394},{34676,72427,95024,12240,72012,0,57763},{97957,56,83817,45472,0,24087,90245},{32056,0,92049,21380,4980,38458,3490},{21509,76628,0,90430,10113,76264,45840},{97192,58807,74165,65921,45726,47265,56084},{16276,27751,37985,47944,54895,80706,2372},{28438,53073,0,67255,38416,63354,69262},{23926,75497,91347,58436,73946,39565,10841},{34372,69647,44093,62680,32424,69858,68719},{24425,4014,94871,1031,99852,88692,31503},{24475,12295,33326,37771,37883,74568,25163},{0,18411,88185,60924,29028,69789,0},{34697,75631,7636,16190,60178,39082,7052},{24876,9570,53630,98605,22331,79320,88317},{27204,89103,15221,91346,35428,94251,62745},{26636,28759,12998,58412,38113,14678,0},{80871,79706,45325,3861,12504,0,4872},{79662,15626,995,80546,64775,0,68820},{25160,82123,81706,21494,92958,33594,5243}};
        List<List<Integer>> forest = new ArrayList<>();
        for(Integer[] i : arr) {
            forest.addAll(Collections.singleton(Arrays.asList(i)));
        }
        CutOffTree cutOffTree = new CutOffTree();
//        System.out.println(cutOffTree.cutOffTree1(forest));
        System.out.println(cutOffTree.cutOffTree(forest));
    }
}
