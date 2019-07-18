package string;

/**
 * @Description: Given a column title as appear in an Excel sheet, return its corresponding column number.
 *
 * For example:
 *
 *     A -> 1
 *     B -> 2
 *     C -> 3
 *     ...
 *     Z -> 26
 *     AA -> 27
 *     AB -> 28
 *     ...
 * Example 1:
 *
 * Input: "A"
 * Output: 1
 * Example 2:
 *
 * Input: "AB"
 * Output: 28
 * Example 3:
 *
 * Input: "ZY"
 * Output: 701
 * @Author:     alex
 * @CreateDate: 2019/7/18 17:23
 * @Version:    1.0
 *
*/
public class ExcelSheetColumnNumber {
    public static void main(String[] args) {
        ExcelSheetColumnNumber excelSheetColumnNumber = new ExcelSheetColumnNumber();
        System.out.println(excelSheetColumnNumber.titleToNumber("AZDFDS"));
    }
    public int titleToNumber(String s) {
        int result = 0;
        int start = 0;
        int len = s.length();
        while(start < len)
            result = result * 26 + (s.charAt(start++) - 'A' + 1);
        return result;
    }
}
