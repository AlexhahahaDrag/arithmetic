package string;

public class KMP {
    public static void main(String[] args) {
        KMP kmp = new KMP();
        String resource = "abcdabceababcgsc";
        String target = "abcg";
        System.out.println(kmp.getKmp(resource, target));
    }
    public int getKmp(String resource, String target) {
        char[] res = resource.toCharArray();
        char[] tar = target.toCharArray();
        int[] k = getNext(res);
        int j = 0;
        int i =0 ;
       while(i < res.length && j < tar.length) {
            if (j == -1 || res[i] == tar[j]) {
                j++;
                i++;
            } else
                j = k[j];
        }
        if (j == tar.length)
            return i - j + 1;
        return -1;
    }

    public int[] getNext(char[] str) {
        int[] next = new int[str.length];
        next[0] = -1;
        int k = -1;
        int j = 0;
        while(j < str.length - 1) {
            if (k == -1 || str[j] == str[k]) {
                j++;
                k++;
                next[j] = k;
            } else
                k = next[k];
        }
        return next;
    }
}
