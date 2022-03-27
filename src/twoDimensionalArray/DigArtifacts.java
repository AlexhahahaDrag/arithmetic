package twoDimensionalArray;

/**
 *description:  
 *author:       alex
 *createDate:   2022/3/13 11:02
 *version:      1.0.0
 */
public class DigArtifacts {
    

    public int digArtifacts(int n, int[][] artifacts, int[][] dig) {
        boolean[][] map = new boolean[n][n];
        for(int[] di : dig) {
            map[di[0]][di[1]] = true;
        }
        int res = 0;
        for(int[] c : artifacts) {
            boolean r = true;
            l:for(int i = c[0]; i <= c[2]; i++) {
                for(int j = c[1]; j <= c[3]; j++) {
                    if(!map[i][j]) {
                        r = false;
                        break l;
                    }
                }
            }
            if(r) {
                res++;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        int n = 6;
        int[][] artifacts = {{0,2,0,5}, {0,1,1,1}, {3,0,3,3}, {4,4,4,4}, {2,1,2,4}};
        int[][] dig = {{0,2}, {0,3}, {0,4}, {2,0}, {2,1}, {2,2}, {2,5}, {3,0}, {3,1}, {3,3}, {3,4}, {4,0}, {4,3}, {4,5}, {5,0}, {5,1}, {5,2}, {5,4}, {5,5}};
        DigArtifacts digArtifacts = new DigArtifacts();
        System.out.println(digArtifacts.digArtifacts(n, artifacts, dig));
    }
}
