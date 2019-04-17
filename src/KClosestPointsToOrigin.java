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
    public static int[][] kClosest(int[][] points,int k){
        if (k>=points.length)
            return points;

        return null;
    }
    public static int[][] getSort(int[][] points){
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points[i].length; j++) {

            }
        }
        return null;
    }
}
