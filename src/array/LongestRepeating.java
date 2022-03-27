package array;

public class LongestRepeating {

    public int[] longestRepeating(String s, String qc, int[] qi) {
        int[] res = new int[qi.length];
        int resi = 0;
        char[] sa = s.toCharArray();
        int[] map = new int[sa.length];
        map[0] = 1;
        for (int i = 1; i < sa.length; i++) {
            if (sa[i - 1] == sa[i]) {
                map[i] = map[i - 1] + 1;
            } else {
                map[i] = 1;
            }
        }
        int max;
        for (int j = 0; j < qi.length; j++) {
            sa[qi[j]] = qc.charAt(j);
            if (qi[j] > 0 && sa[qi[j] - 1] == sa[qi[j]]) {
                map[qi[j]] = map[qi[j] - 1] + 1;
            } else {
                map[qi[j]] = 1;
            }
            if (qi[j] < sa.length - 1) {
                int init = 1;
                if (sa[qi[j] + 1] == sa[qi[j]]) {
                    init = map[qi[j]] + 1;
                    map[qi[j] + 1] = init;
                }
                int k = qi[j];
                while (++k < sa.length && map[k] > 1) {
                    map[k] = init++;
                }
            }
            max = 0;
            for (int i : map) {
                max = Math.max(max, i);
            }
            res[resi++] = max;
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "abyzz";
        String qc = "aa";
        int[] qi  = {2,1};//[2,3]
//            String s = "babacc";
//            String qc = "bcb";
//            int[] qi  = {1,3,3};

//        String s = "geuqjmt";
//        String qc = "bgemoegklm";
//               int[] qi = {3,4,2,6,5,6,5,4,3,2};//[1,1,2,2,2,2,2,2,2,1]
        LongestRepeating longestRepeating = new LongestRepeating();
        int[] ints = longestRepeating.longestRepeating(s, qc, qi);
        for (int i : ints) {
            System.out.print(i + ",");
        }
    }
}
