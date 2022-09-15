package math;

import java.util.HashSet;
import java.util.Set;

/**
 * @description:
 * @author: alex
 * @createDate: 2022/9/15 20:42
 * @version: 1.0.0
 */
public class FlipLights {

    public int flipLights1(int n, int presses) {
        //false为开 true为关
        boolean[] status = new boolean[n + 1];
        Set<String> res = new HashSet<>();
        dfs(status, presses, res);
        return res.size();
    }

    private void dfs(boolean[] status, int presses, Set<String> res) {
        if (presses == 0) {
            StringBuilder sb = new StringBuilder();
            for (boolean i : status) {
                sb.append(i).append(",");
            }
            res.add(sb.toString());
            return;
        }
        boolean[] cur;
        for (int i = 0; i < 4; i++) {
            cur = new boolean[status.length];
            for (int j = 1; j < status.length; j++) {
                switch (i) {
                    case 0:
                        cur[j] = !status[j];
                        break;
                    case 1:
                        cur[j] = j % 2 == 0 ? !status[j] : status[j];
                        break;
                    case 2:
                        cur[j] = j % 2 == 0 ? status[j] : !status[j];
                        break;
                    default:
                        cur[j] = (j - 1) % 3 == 0 ? !status[j] : status[j];
                }
            }
            dfs(cur, presses - 1, res);
        }
    }

    public int flipLights(int n, int presses) {
        if (presses == 0) {
            return 1;
        }
        if (n == 1) {
            return 2;
        } else if (n == 2) {
            return presses == 1 ? 3 : 4;
        } else {
            return presses == 1 ? 4 : presses == 2 ? 7 : 8;
        }
    }

    public static void main(String[] args) {
//        int n = 18;
//        int pressure = 5;//8
        int n = 1;
        int pressure = 1;//8
        FlipLights flipLights = new FlipLights();
        System.out.println(flipLights.flipLights(n, pressure));
    }
}
