/**
 * @Description: In an alien language, surprisingly they also use english lowercase letters, but possibly in a different order. The order of the alphabet is some permutation of lowercase letters.
 *
 * Given a sequence of words written in the alien language, and the order of the alphabet, return true if and only if the given words are sorted lexicographicaly in this alien language.
 *
 *
 *
 * Example 1:
 *
 * Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
 * Output: true
 * Explanation: As 'h' comes before 'l' in this language, then the sequence is sorted.
 * Example 2:
 *
 * Input: words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
 * Output: false
 * Explanation: As 'd' comes after 'l' in this language, then words[0] > words[1], hence the sequence is unsorted.
 * Example 3:
 *
 * Input: words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
 * Output: false
 * Explanation: The first three characters "app" match, and the second string is shorter (in size.) According to lexicographical rules "apple" > "app", because 'l' > '∅', where '∅' is defined as the blank character which is less than any other character (More info).
 *
 *
 * Note:
 *
 * 1 <= words.length <= 100
 * 1 <= words[i].length <= 20
 * order.length == 26
 * All characters in words[i] and order are english lowercase letters.
 * @Author:      alex
 * @CreateDate:  2019/2/13 17:33
 * @param
 * @return
*/
public class VerifyingAnAlienDictinary {
    public static void main(String[] args) {
        String[] strings={"word","world","row"};
        String order = "worldabcefghijkmnpqstuvxyz";
        System.out.println(isAlienSorted(strings,order));
    }
    public static boolean isAlienSorted(String[] words, String order) {
        for (int i = 0; i < words.length-1; i++)
            if (!getSort(words[i],words[i+1],order))
                return false;
        return true;
    }
    public static boolean getSort(String s1,String s2,String order){
        int i=0;
        while(i<s1.length()&&i<s2.length()){
            if (order.indexOf(s1.charAt(i))<order.indexOf(s2.charAt(i)))
                return true;
            else if(order.indexOf(s1.charAt(i))==order.indexOf(s2.charAt(i)))
                i++;
            else
                return false;
        }
        if (s1.length()>i)
            return false;
        return true;
    }
}
