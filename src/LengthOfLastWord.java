/**
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
 *
 * If the last word does not exist, return 0.
 *
 * Note: A word is defined as a character sequence consists of non-space characters only.
 *
 * Example:
 *
 * Input: "Hello World"
 * Output: 5
 */
public class LengthOfLastWord {
    public static void main(String[] args) {
        System.out.println(getLengthOfLastWord("  "));
    }
    public static int getLengthOfLastWord(String s){
        if (s==null)
            return 0;
        String[] strings=s.split(" ");
        if(strings.length==0)
            return 0;
        return strings[strings.length-1]==null?0:strings[strings.length-1].length();
    }
}
