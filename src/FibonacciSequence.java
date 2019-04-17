/**
 * @Description: 给定数列 1, 1, 1, 3, 5, 9, 17, …，从第 4 项开始，每项都是前 3 项的和。求
 * 第 20190324 项的最后 4 位数字
 * 规律：两项：斐波那契数个位数60步一循环，最后两位数300步一循环，最后三位数1500步一循环，
 * 最后四位数15000步一循环，最后五位数150000步一循环。
 * 三项：：斐波那契数个位数62步一循环，最后两位数620步一循环，最后三位数6200步一循环，
 *  * 最后四位数62000步一循环，最后五位数620000步一循环。
 * @Author:      alex
 * @CreateDate:  2019/4/4 10:10
 * @param
 * @return
*/
public class FibonacciSequence {
    public static void main(String[] args) {
        System.out.println(getFouth(20190324));
    }
    public static int getFouth(int num){
        if(num<=3)
            return 1;
        num%=62000;
        int a=1;
        int b=1;
        int c=1;
        int sum=0;
        while(num-->3){
            sum=(a+b+c)%10000;
            a=b;
            b=c;
            c=sum;
        }
        return sum;
    }
}
