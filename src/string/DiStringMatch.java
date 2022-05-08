package string;

/**
 *description:
 *
 *author:       alex
 *createDate:   2022/5/9 7:08
 *version:      1.0.0
 */
public class DiStringMatch {

    public int[] diStringMatch1(String s) {
        int len = s.length();
        int[] res = new int[len + 1];
        for(int i = 0; i <= len; i++) {
            res[i] = i;
        }
        int j = 0;
        int end = len;
        while(j < len) {
            if (s.charAt(j) == 'D') {
                if (res[j] < res[j + 1]) {
                    int cur = res[j];
                    res[j] = res[end];
                    res[end--] = cur;
                }
            } else {
                int k = j;
                while(res[k] > res[k + 1] && s.charAt(k) == 'I') {
                    int cur = res[k];
                    res[k] = res[k + 1];
                    res[k-- + 1] = cur;
                }
            }
            j++;
        }
        return res;
    }

    public int[] diStringMatch(String s) {
        int st = 0;
        int en = s.length();
        int[] res = new int[en + 1];
        int len = en;
        int i = 0;
        while(i < len) {
            if (s.charAt(i) == 'D') {
                res[i] = en--;
            } else {
                res[i] = st++;
            }
            i++;
        }
        res[i] = st;
        return res;
    }

    public static void main(String[] args) {
        String s = "DDI";
        DiStringMatch diStringMatch = new DiStringMatch();
        int[] res = diStringMatch.diStringMatch(s);
        for(int i : res) {
            System.out.print(i + " ");
        }
    }
}
