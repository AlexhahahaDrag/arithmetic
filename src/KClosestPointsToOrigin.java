import java.util.Arrays;

public class KClosestPointsToOrigin {
    public static void main(String[] args) {
        int[][] point={{1,3},{-2,2}};
        int[][] points=kClosest(point,1);
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points[i].length; j++) {
                System.out.print(points[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static int[][] kClosest1(int[][] points,int K){
        int[][] results=new int[K][2];
        if(K>=points.length)
            return points;
        int[] x=new int[points.length];
        for(int i=0;i<x.length;i++)
            x[i]=distance(points[i]);
        Arrays.sort(x);
        int index=0;
        for(int i=0;i<points.length;i++){
            if(distance(points[i])<x[K]){
                results[index][0]=points[i][0];
                results[index][1]=points[i][1];
                index++;
                if(index==K)
                    break;
            }
        }
        return results;
    }
    public static int[][] kClosest(int[][] points, int K) {
        if(points == null || points.length == 0) return points;
        if(K < 1) return new int[][]{{0,0}};
        int left = 0;
        int right = points.length - 1;
        while(left < right) {
            int pivot = quicksort(points, left, right);
            if(pivot == K) {
                break;
            }
            else if(pivot < K) {
                left = pivot;
            }else {
                right = pivot - 1;
            }
        }
        return Arrays.copyOf(points, K);
    }

    public static int quicksort(int[][] points, int b, int e) {
        int pivot = b +  (e - b) / 2;
        int powerPivot = distance(points[pivot]);
        while(b <= e) {
            while (distance(points[b]) < powerPivot && b <= e){
                b++;
            }
            while(distance(points[e]) > powerPivot && b <= e) {
                e--;
            }
            if (b<=e) {
                int[] tmpX = points[b];
                points[b] = points[e];
                points[e] = tmpX;
                b++;
                e--;
            }//switch
        }
        return b;
    }

    public static int distance(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
}
