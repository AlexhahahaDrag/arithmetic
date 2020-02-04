package string;
/**
 *description:
 * 给定两个二进制字符串，返回他们的和（用二进制表示）。
 *
 * 输入为非空字符串且只包含数字 1 和 0。
 *
 * 示例 1:
 *
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 示例 2:
 *
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-binary
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *author:       alex
 *createDate:  2020/2/4 10:02
 *version:      1.0.0
*/
public class AddBinary {

    public String addBinary(String a, String b) {
        int indexA = a.length() - 1;
        int indexB = b.length() - 1;
        int digit = 0;
        StringBuilder sb = new StringBuilder();
        while(digit > 0 || indexA >= 0 || indexB >= 0) {
            int numA = indexA >= 0 ? a.charAt(indexA--) - '0' : 0;
            int numB = indexB >= 0 ? b.charAt(indexB--) - '0' : 0;
            int sum = numA + numB + digit;
            digit = sum / 2;
            sb.insert(0, sum % 2);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        AddBinary addBinary = new AddBinary();
        String a = "11";
        String b = "1";
        System.out.println(addBinary.addBinary(a, b));
    }
}
