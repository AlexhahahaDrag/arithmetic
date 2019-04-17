/**
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.
 *
 * For example:
 *
 *     1 -> A
 *     2 -> B
 *     3 -> C
 *     ...
 *     26 -> Z
 *     27 -> AA
 *     28 -> AB
 *     ...
 * Example 1:
 *
 * Input: 1
 * Output: "A"
 * Example 2:
 *
 * Input: 28
 * Output: "AB"
 * Example 3:
 *
 * Input: 701
 * Output: "ZY"
 */
public class ConvertToTitle {
    public static String convertToTile(int n){
        if (n<=0)
            return "";
        char[] arr=new char[26];
        char a='A';
        for (int i = 0; i < 26; i++) {
            arr[i]=a++;
        }
        String title="";
        while (n>0){
            if (n%26==0) {
                title = 'Z' + title;
                n -= 1;
            }else
                title=arr[n%26-1]+title;
            n/=26;
        }
        return title;
    }
    public static String convertToTile1(int n){
        String res = "";
        while (n > 0)
        {
            res = (char)(65+((n-1)%26)) + res;
            n = (n-1) / 26;
        }
        return res;
    }
    public static void main(String[] args) {
        System.out.println(convertToTile(703 ));
    }
}
