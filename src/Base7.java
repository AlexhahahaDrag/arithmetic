/**
 * @Description: Given an integer, return its base 7 string representation.
 *
 * Example 1:
 * Input: 100
 * Output: "202"
 * Example 2:
 * Input: -7
 * Output: "-10"
 * Note: The input will be in range of [-1e7, 1e7].
 * @Author:      alex
 * @CreateDate:  2019/2/25 17:35
 * @param
 * @return
*/
public class Base7 {
    public static void main(String[] args) {
        System.out.println(convertToBase7(10));
    }
    public static String convertToBase7(int num) {
        boolean negetive=false;
        if(num<0){
            num=-num;
            negetive=true;
        }
        StringBuilder sb=new StringBuilder();
        if(num==0)
            sb.append(0);
        while(num>0){
            sb.insert(0,num%7);
            num/=7;
        }
        if(negetive)
            sb.insert(0,"-");
        return sb.toString();
    }
}
