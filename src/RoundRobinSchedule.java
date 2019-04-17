import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *   设有n=2^k个运动员要进行网球循环赛。现要设计一个满足以下要求的比赛日程表：
 *
 *         (1)每个选手必须与其他n-1个选手各赛一次；
 *      (2)每个选手一天只能参赛一次；
 *      (3)循环赛在n-1天内结束。
 */
public class RoundRobinSchedule {
    public static void main(String[] args) {
        while (true){
            System.out.println("请输入数字：");
            Scanner sc=new Scanner(System.in);
            String k=sc.next();
            String rule="\\d*";
            Pattern pattern=Pattern.compile(rule);
            Matcher matcher=pattern.matcher(k);
            if(matcher.matches()){
                int a=Integer.parseInt(k);
                int num=(int)Math.pow(2,a);
                int[][] arr=new int[num][num];
                for (int i = 0; i < a; i++) {
                    getRoundRobinSchedual(arr);
                }
                for (int i = 0; i < arr.length; i++) {
                    for (int j = 0; j < arr[i].length; j++) {
                        System.out.print(arr[i][j]+"  ");
                    }
                    System.out.println();
                }
            }else {
                System.out.println("请输入数字！！");
            }
        }
    }
    public static int[][] getRoundRobinSchedual(int[][] arr){
        for (int j = 0; j < arr[0].length; j++) {
            arr[0][j]=j+1;
        }
        return arr;
    }
}
