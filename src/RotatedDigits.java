import java.util.Arrays;

/**
 * @Description: X is a good number if after rotating each digit individually by 180 degrees, we get a valid number that is different from X.  Each digit must be rotated - we cannot choose to leave it alone.
 *
 * A number is valid if each digit remains a digit after rotation. 0, 1, and 8 rotate to themselves; 2 and 5 rotate to each other; 6 and 9 rotate to each other, and the rest of the numbers do not rotate to any other number and become invalid.
 *
 * Now given a positive number N, how many numbers X from 1 to N are good?
 *
 * Example:
 * Input: 10
 * Output: 4
 * Explanation:
 * There are four good numbers in the range [1, 10] : 2, 5, 6, 9.
 * Note that 1 and 10 are not good numbers, since they remain unchanged after rotating.
 * Note:
 *
 * N  will be in range [1, 10000].
 * @Author:      alex
 * @CreateDate:  2019/2/28 15:46
 * @param
 * @return
 */
public class RotatedDigits {
    public static void main(String[] args) {
        System.out.println(rotatedDigits(857));
    }
    public static int rotatedDigits1(int N) {
        int count=0;
        for(int i=1;i<=N;i++) {
            int[] index = new int[10];
            for (char ch:String.valueOf(i).toCharArray())
                index[ch-'0']++;
            if (index[3]+index[4]+index[7]>0||index[2]+index[5]+index[6]+index[9]==0)
                continue;
            count++;
        }
        return count;
    }
    public static int rotatedDigits2(int N) {
        boolean[] flags=new boolean[N+1];
        int count=0;
        for(int i=1;i<=N;i++) {
            if(flags[i])
                count++;
            else{
                int[] index = new int[10];
                for (char ch:String.valueOf(i).toCharArray())
                    index[ch-'0']++;
                if (index[3]+index[4]+index[7]>0||index[2]+index[5]+index[6]+index[9]==0)
                    continue;
                int rotatedI=0;
                int j=i;
                while(j>0){
                    int a=j%10;
                    switch (a){
                        case 1:a=1;break;
                        case 0:a=0;break;
                        case 2:a=5;break;
                        case 5:a=2;break;
                        case 6:a=9;break;
                        case 9:a=6;break;
                    }
                    rotatedI=rotatedI*10+a;
                    j/=10;
                }
                if(rotatedI>i&&rotatedI<=N)
                    flags[rotatedI]=true;
                count++;
            }
        }
        return count;
    }
    public static int rotatedDigits(int N) {
        int[] x;
        int[] all={0,1,2,5,6,8,9};
        int[] aa={2,5,6,9};
        int ret=0;
        boolean check=false;
        while(N!=0){
            //System.out.print(N);
            x=getLast(N);
            if (x[1]>1) ret+=calculate(x[0]*((int)Math.pow(10,x[1]-1))-1,check);
            else ret+=calculate(x[0]*((int)Math.pow(10,x[1]-1)),check);

            if (Arrays.binarySearch(all,x[0])<0) break;
            else{
                if (check==false && Arrays.binarySearch(aa,x[0])>-1) check=true;
                N-=x[0]*((int)Math.pow(10,x[1]-1));
                if (N==0 && x[1]!=1 && check) ret++;
            }
        }
        return ret;

    }
    private static int calculate(int inp, boolean check){
        int x=1,y=1;
        int xm,ym;
        int[] all={0,1,2,5,6,8,9};
        int[] aa={0,1,8};
        while (inp!=0){
            if (inp<10){
                xm= Arrays.binarySearch(all,inp);
                if (xm<0) xm=(xm+1)*-1;
                else xm+=1;
                ym=Arrays.binarySearch(aa,inp);
                if (ym<0) ym=(ym+1)*-1;
                else ym+=1;
                x*=xm;
                y*=ym;
            }else{
                x*=7;
                y*=3;
            }
            inp/=10;
        }
        if (check) return x;
        else return x-y;
    }
    private static int[] getLast(int inp){
        int[] ret= new int[2];
        while (inp!=0){
            ret[0]=inp%10;
            ret[1]++;
            inp/=10;
        }
        return ret;
    }
}
