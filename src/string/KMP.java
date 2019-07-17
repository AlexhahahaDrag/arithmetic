package string;

public class KMP {
    public static void main(String[] args) {
        KMP kmp = new KMP();
        String resource = "abcgabeeababcgabcsc";
        String target =   "abcgabc";
        System.out.println(kmp.getKmp(resource, target));
    }
    public int getKmp(String resource, String target) {
        char[] res = resource.toCharArray();
        char[] tar = target.toCharArray();
        int[] k = getNext(tar);
        int j = 0;
        int i = 0;
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
        int k = 0;
        int j = 1;
        while(j < str.length ) {
            if (k == 0 || str[j] == str[k]) {
                next[j] = k;
                j++;
                k++;
            } else
                k = next[k];
        }
        return next;
    }
}
