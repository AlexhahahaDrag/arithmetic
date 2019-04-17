import java.util.*;

/**
 * 牛牛有N个字符串，他想将这些字符串分类，他认为两个字符串A和B属于同一类需要满足以下条件：
 * A中交换任意位置的两个字符，最终可以得到B，交换的次数不限。比如：abc与bca就是同一类字符串。
 * 现在牛牛想知道这N个字符串可以分成几类。
 * 输入描述:
 * 首先输入一个正整数N（1 <= N <= 50），接下来输入N个字符串，每个字符串长度不超过50。
 * 输出描述:
 * 输出一个整数表示分类的个数。
 * 示例1
 * 输入
 * 4
 * abcd
 * abdc
 * dabc
 * bacd
 * 输出
 * 1
 */
public class StringSort {
    public static void main(String[] args) {
        while (true){
            Scanner sc=new Scanner(System.in);
            int a1=sc.nextInt();
            if (a1>0&&a1<=50){
                Set<String> set=new HashSet<>();
                while (a1>0){
                    Scanner sc1=new Scanner(System.in);
                    String s=sc1.next();
                    String s1=sortString(s);
                    set.add(s1);
                    a1--;
                }
                System.out.println(set.size());
            }else {
                System.out.println("要求每个字符串的长度不超过50");
            }
        }
    }
    public static String sortString(String string){
        byte[] b=string.getBytes();
        Arrays.sort(b);
        return new String(b);
    }

}
