package twoDimensionalArray;

public class KWeakestRows {

    public int[] kWeakestRows(int[][] mat, int k) {
        int[] result = new int[k];
        boolean[] map = new boolean[mat.length];
        int num = 0;
        for(int i = 0; i < mat[0].length; i++) {
            for(int j = 0; j < mat.length; j++) {
                if(!map[j] && mat[j][i] == 0) {
                    map[j] = true;
                    result[num++] = j;
                    if(num == k)
                        return result;
                }
            }
        }
        int start = 0;
        while(num <= k){
            if(!map[start])
                result[num++] = start;
            start++;
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] mat = {{1,1,1,1,1}, {1,1,1,1,1}, {1,1,1,1,1}};
        KWeakestRows kWeakestRows = new KWeakestRows();
        int[] result = kWeakestRows.kWeakestRows(mat, 1);
        for (int i : result)
            System.out.print(i +" ");
    }
}
