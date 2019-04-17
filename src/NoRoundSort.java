/**一个整数，大于0，不用循环和本地变量，按照n,2n,4n,8n的顺序递增，
        当值大于5000时，把值按照指定顺序输出来。*/
public class NoRoundSort {
    public static void main(String[] args) {
        count(1377,0);
    }
    public static void count(int num,int a){
        System.out.print(num+"    ");
        if (num<10000){
            a++;
            num*=2;
            count(num,a);
            num/=2;
        }
        System.out.print(num+"    ");
    }
}
