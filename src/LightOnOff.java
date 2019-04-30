/**
 * @Description:
 * @Author:      alex
 * @CreateDate:  2019/4/30 12:31
 * @param
 * @return
*/
public class LightOnOff {
    public static void main(String[] args) {
        int[][] light=getLightOn();
        for (int i = 0; i < light.length; i++) {
            for (int j = 0; j < light[i].length; j++) {
                System.out.print(light[i][j]+"  ");
            }
            System.out.println();
        }
    }
    public static int[][] getLightOn(){
        int[][] light=new int[6][8];
        boolean flag=false;
        while(!flag){
            int c=1;
            light[1][c]++;
            while(light[1][c]>1){
                light[1][c]=0;
                c++;
                light[1][c]++;
            }
            flag=chechLight(light);
            if (flag)
                return light;
        }
        return new int[0][0];
    }
    public static boolean chechLight(int[][] light){
        int[][] press=new int[6][8];
        for (int i = 1; i < 5; i++) {
            for (int j = 1; j < 7; j++)
                press[i+1][j]=(light[i][j]+press[i-1][j]+press[i][j-1]+press[i][j+1]+press[i][j])&1;
        }
        for (int i = 1; i < 7; i++) {
            light[5][i]=(press[5][i-1]+press[5][i]+press[5][i+1]+press[4][i])&1;
            if (light[5][i]==1)
                return false;
        }
        return true;
    }
}
