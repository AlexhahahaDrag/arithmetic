import java.util.LinkedList;

public class UpdateMatrix {
    public static void main(String[] args) {
        UpdateMatrix updateMatrix = new UpdateMatrix();
        int[][] arr = {{0,1,0},{0,1,0},{0,1,0},{0,1,0},{0,1,0}};
        updateMatrix.updateMatrix(arr);
    }
    public int[][] updateMatrix(int[][] matrix) {
        int[][] result = new int[matrix.length+4][matrix[0].length+4];
        for (int i = 0; i < result.length; i++) {
            result[i][0] = Integer.MAX_VALUE;
            result[i][1] = Integer.MAX_VALUE;
            result[i][result[0].length-2] = Integer.MAX_VALUE;
            result[i][result[0].length-1] = Integer.MAX_VALUE;
        }
        for (int j = 0; j < result[0].length; j++) {
            result[0][j] = Integer.MAX_VALUE;
            result[1][j] = Integer.MAX_VALUE;
            result[result.length-2][j] = Integer.MAX_VALUE;
            result[result.length-1][j] = Integer.MAX_VALUE;
        }
        LinkedList<Ma> linkedList = new LinkedList<>();
        for (int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] == 0) {
                    linkedList.add(new Ma(i+2,j+2));
                } else {
                    result[i+2][j+2] =  Integer.MAX_VALUE;
                }
            }
        }
        int i;
        int j;
        while (linkedList.size() !=0) {
            Ma ma = linkedList.pop();
            i = ma.i;
            j = ma.j;
            if (result[i][j-1] == Integer.MAX_VALUE) {
                result[i][j-1] = finMin(result,i,j-1);
                if (j-1 > 1) {
                    linkedList.add(new Ma(i,j-1));
                }
            }
            if (result[i][j+1] == Integer.MAX_VALUE) {
                result[i][j+1] = finMin(result,i,j+1);
                if (j+1 < result[i].length-2) {
                    linkedList.add(new Ma(i,j+1));
                }
            }
            if (result[i-1][j] == Integer.MAX_VALUE) {
                result[i-1][j] = finMin(result,i-1,j);
                if (i-1 > 1) {
                    linkedList.add(new Ma(i-1,j));
                }
            }
            if (result[i+1][j] == Integer.MAX_VALUE) {
                result[i+1][j] = finMin(result,i+1,j);
                if (i+1 < result.length-2) {
                    linkedList.add(new Ma(i+1,j));
                }
            }
        }
        for (int k = 0; k < matrix.length; k++) {
            for(int l = 0; l < matrix[k].length; l++) {
                matrix[k][l] = result[k+2][l+2];
            }
        }
        return matrix;
    }
    private class Ma {
        Integer i;
        Integer j;
        private Ma(Integer i, Integer j) {
            this.i = i;
            this.j = j;
        }
    }
    private int finMin(int[][] result, int i, int j) {
        return Math.min(Math.min(result[i-1][j],result[i+1][j]),Math.min(result[i][j+1],result[i][j-1]))+1;
    }
}
