package string;

/**
 *description:
 * 171. Excel表列序号
 * 给定一个Excel表格中的列名称，返回其相应的列序号。
 *
 * 例如，
 *
 *     A -> 1
 *     B -> 2
 *     C -> 3
 *     ...
 *     Z -> 26
 *     AA -> 27
 *     AB -> 28
 *     ...
 * 示例 1:
 *
 * 输入: "A"
 * 输出: 1
 * 示例 2:
 *
 * 输入: "AB"
 * 输出: 28
 * 示例 3:
 *
 * 输入: "ZY"
 * 输出: 701
 * 致谢：
 * 特别感谢 @ts 添加此问题并创建所有测试用例。
 *author:       alex
 *createDate:  2020/3/25 17:59
 *version:      1.0.0      
*/
public class TitleToNumber {

    public int titleToNumber(String s) {
        int res = 0;
        int index = 0;
        int len = s.length();
        while(index < len)
            res = res * 26 + s.charAt(index++) - 'A' + 1;
        return res;
    }

    public static void main(String[] args) {
        TitleToNumber titleToNumber = new TitleToNumber();
        System.out.println(titleToNumber.titleToNumber("ZY"));
    }
}
