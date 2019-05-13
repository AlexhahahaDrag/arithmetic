public class FlippingAnImage {
    public static void main(String[] args) {
        int[][] A={{1,1,0,0},{1,0,0,1},{0,1,1,1},{1,0,1,0}};
        int[][] result=flipAndInvertImage(A);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                System.out.print(result[i][j]+"     ");
            }
            System.out.println();
        }
    }
    public static int[][] flipAndInvertImage(int[][] A) {
        for(int i=0;i<A.length;i++){
            for(int j=0;j<(A[i].length>>1);j++){
                int temp=A[i][j];
                A[i][j]=A[i][A[i].length-j-1];
                A[i][A[i].length-j-1]=temp;
            }
        }
        for(int i=0;i<A.length;i++){
            for(int j=0;j<A[i].length;j++){
                if(A[i][j]==0)
                    A[i][j]=1;
                else
                    A[i][j]=0;
            }
        }
        return A;
    }
}
