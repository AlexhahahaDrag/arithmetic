import java.util.HashMap;
import java.util.Map;

/**
 * @Description: Given a paragraph and a list of banned words, return the most frequent word that is not in the list of banned words.  It is guaranteed there is at least one word that isn't banned, and that the answer is unique.
 *
 * Words in the list of banned words are given in lowercase, and free of punctuation.  Words in the paragraph are not case sensitive.  The answer is in lowercase.
 *
 *
 *
 * Example:
 *
 * Input:
 * paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
 * banned = ["hit"]
 * Output: "ball"
 * Explanation:
 * "hit" occurs 3 times, but it is a banned word.
 * "ball" occurs twice (and no other word does), so it is the most frequent non-banned word in the paragraph.
 * Note that words in the paragraph are not case sensitive,
 * that punctuation is ignored (even if adjacent to words, such as "ball,"),
 * and that "hit" isn't the answer even though it occurs more because it is banned.
 *
 *
 * Note:
 *
 * 1 <= paragraph.length <= 1000.
 * 1 <= banned.length <= 100.
 * 1 <= banned[i].length <= 10.
 * The answer is unique, and written in lowercase (even if its occurrences in paragraph may have uppercase symbols, and even if it is a proper noun.)
 * paragraph only consists of letters, spaces, or the punctuation symbols !?',;.
 * There are no hyphens or hyphenated words.
 * Words only consist of letters, never apostrophes or other punctuation symbols.
 * @Author:      alex
 * @CreateDate:  2019/2/13 15:06
 * @param
 * @return
*/
public class MostCommonWord {
    public static void main(String[] args) {
        String[] banned = {"hit"};
        System.out.println(mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.",banned));
    }
    public static String mostCommonWord(String paragraph, String[] banned) {
        Map<String,Integer> map=new HashMap<>();
        Map<String,Integer> map1=new HashMap<>();
        String lowerPragraph=paragraph.toLowerCase().replaceAll("[^a-z]"," ");
        String[] strings=lowerPragraph.split(" ");
        for (int i = 0; i < banned.length; i++)
            map.put(banned[i],map.getOrDefault(banned[i],0));
        int mostNum=0;
        String mostCommon="";
        for (int i = 0; i < strings.length; i++) {
            if (!"".equals(strings[i])&&!map.containsKey(strings[i])){
                map1.put(strings[i],map1.getOrDefault(strings[i],0)+1);
                if (map1.get(strings[i]).intValue()>mostNum){
                    mostNum=map1.get(strings[i]).intValue();
                    mostCommon=strings[i];
                }
            }
        }
        return mostCommon;
    }
}
