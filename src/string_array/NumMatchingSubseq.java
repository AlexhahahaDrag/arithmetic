package string_array;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * description:
 * 792. 匹配子序列的单词数
 * 中等
 * 268
 * 相关企业
 * 给定字符串 s 和字符串数组 words, 返回  words[i] 中是s的子序列的单词个数 。
 * <p>
 * 字符串的 子序列 是从原始字符串中生成的新字符串，可以从中删去一些字符(可以是none)，而不改变其余字符的相对顺序。
 * <p>
 * 例如， “ace” 是 “abcde” 的子序列。
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "abcde", words = ["a","bb","acd","ace"]
 * 输出: 3
 * 解释: 有三个是 s 的子序列的单词: "a", "acd", "ace"。
 * Example 2:
 * <p>
 * 输入: s = "dsahjpjauf", words = ["ahjpjau","ja","ahbwzgqnuk","tnmlanowax"]
 * 输出: 2
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= s.length <= 5 * 104
 * 1 <= words.length <= 5000
 * 1 <= words[i].length <= 50
 * words[i]和 s 都只由小写字母组成。
 * author:       majf
 * createDate:   2022/11/17 11:09
 * version:      1.0.0
 */
public class NumMatchingSubseq {

    Map<String, Boolean> map = new HashMap<>();
    public int numMatchingSubseq(String s, String[] words) {
        int res = 0;
        for (String word : words) {
            if (judge(s, word)) {
                res++;
            }
        }
        return res;
    }

    private boolean judge(String s, String word) {
        Boolean cur = map.get(word);
        if (cur != null && cur) {
            return true;
        }
        if (s.length() < word.length()) {
            return false;
        }
        int ls = s.length();
        int lw = word.length();
        int is = 0;
        int iw = 0;
        while (is < ls && iw < lw) {
            while (is < ls && s.charAt(is) != word.charAt(iw)) {
                is++;
            }
            is++;
            if (is <= ls) {
                iw++;
            }
        }
        boolean res = iw == lw ? true : false;
        map.put(word, res);
        return res;
    }

    public static void main(String[] args) {
        String s = "abcde";
        String[] words = {"a","bb","acd","ace"};//3
//        String s = "dsahjpjauf";
//        String[] words = {"ahjpjau","ja","ahbwzgqnuk","tnmlanowax"}; //2
//        String s = "kwyvpqbthzyvlspalhwnxnxuqnoquukfqrqrzezaxqxxylvperctdwahwfqstrxeksumnvsjvdcrazymzspqchnccihqfbgotmqgetvxeieyptbzjhnlbvxbjwckscujkzmodrazglthaadzlhdcatkxfxqkxxinvsfdmavdmhwdwknhbahvaiugfwppvzhvusvanxlacelycxxetbreykgygskvtikzvtuswnuwiiolylmmqzeolzsauhxrjxndyvwpzxkfrcywzkpxeifkatsxnobsdhrkfzouokybywkdccsxmietrqwcwqmwpxoeuriolrvkuxsxbllquactpqmrtzdugbbuhmuwbvwkbtthubtsaqxumwviwcblfwkplbvameldbkndhbzougsldayvvimodwhcrotxrqisnjxoegxgkafdsrgfmblkpmiqydtyxejusciilthovsebdjsxlnnfghkdkvmpoiulblsqdxgimnwccvbrheeupcwcoqomzigaesrugvlaqqsoghsbafjudazeqbbqwvmcudbsbaklariyqvnuvezqdfjdhnfudktsarsanomhxqxggjzbslelxwfixgzkxcdsaafixcnuhbixzeskmaqucdhgesiqzvpetuehawaevisviybrtevkgpxlgdvygubzahzqhtscwuzgcabhqphgfgvgaaocahzulumcfnugafcfrflwzpijmqdcdmrksvwuluzehmgvvjfzctdtwmdppzfbiciizrguhvsfieawiuiyuvxyniwwlxjmqejlwycornxkhzhcbnvzlkovjnfhnsasscugrduwjhfloeyhjpgcpgobrftesppkdtflqodcpncpetxudohpibgajpfwaxpncapaktncxpgikwomzcshupklkkdidadlvoyqgeckxfuwmoqtqijzcxvlriuupwamfibspyrzsxvscegcixedhycryxgylmjvvcmhgojw";
//        String[] words = {"hnlbvxbjwckscujkzmodrazglthaadzlhdcatkxfxqkx", "nobsdhrkfzouokybywkdccsxmietrqwcwqmwpxo", "yqgeckxfuwmoqtqijzcxvlriuupw", "rflwzpijmqdcdmrksvwuluz", "gafcfrflwzpijmqdc", "hvsfieawiuiyuvxy", "ybywkdccsxmietrqwcwqmwpxoeurio", "mzspqchnccihqfbgotmqgetvxeieyptbzjhn", "sbaklariyqvnuve", "zkpxeifkatsxnobsdhrkfzouokybywkdccsxmi", "srgfmblkpmiqydtyxejusciilthovsebdjsxl", "sauhxrjxndyvwp", "lbvxbjwckscujkzmodrazglthaadzlhdcatkxfxqkx", "ifkatsxnobsdhrkfzouokybywkdccsxmietrqwcwqmwpxoeur", "ctdtwmdppzfbiciizrguhvsfieawiuiyuvxyniwwlxj", "zctdtw", "xlacelycxxetbreykgy", "wuzgcabhqphgfgvgaaocahzulumcfnugafcfrf", "ksvwuluzehmgvvjfzct", "hrkfzouokybywkdccsxmietrq", "ibgajpfwaxpncapaktncxpg", "aadzlhdcatkxfxqkxxinvsfdmavdmhwdwknh", "olrvkuxsxbllquactpqmrtzdugbbuhmuwbvwkbtthubtsaqxu", "xgkafdsrgfmblkpmiqydtyxejusciilthovsebdjsxlnnfghk", "wmoqtqijzcxvlriuupwamfibspyrzsxvscegcixedhycry", "ibgajpfwaxpncapaktncxpgikwomzcshupklkkdidadlvoyqge", "aocahzulumcfnugafcfr", "qxggjzbslelxwfixgzkxcdsaafixcnuhbixzeskmaqucdhges", "tyxejus", "kdtflqodcpncpetxudo", "fudktsarsanomhxqxggjzbs", "umnvsjvdcrazymzspqchnccihqfbgotm", "snjxoegxgkafdsrgfmblkpmiqydt", "ygskvtikzvtuswnuwiio", "dcrazymzspqchnc", "rotxrqisnjxoegxgkafdsrgfmblkpmiqydtyxejusciil", "xeieyptbzjhnlbvxbj", "xfxqkxxinvsfdmavdmhwdwknhb", "kgygskvtikzvtuswnuwiiolylmmqzeolzsauhxrjxn", "afcfrflwzpijmqdcdmrksvwuluzehmgv", "vanx", "xvlriuupwamfibspyrzsxvsce", "tflqodcpncpetxudohpibgajpfwaxpncapaktncxpgikwo", "bafjudazeqbbqwvmcudbsbaklariyqvnuvezqdfjd", "wfqstrxeksumnv", "lnnfghkdkvmpoiulblsqdxgimnwccvbrhe", "blfwkplbvameldbkn", "ccsxmietrqwcwqmwpxoeuriolrvkuxsxbllquactpqmrt", "eieyptbzjhnlbvxbjwckscujkzmodrazglthaa", "slelxwfixgzkxcdsaafixcnuhb", "ppdsxfksvwdnttzkzdqzjogutzbuogkstwymhuzakwkazcilmz", "luhiqkykzquprdllauiitlfwecarknxjricrkesqljtzfxpvha", "xlzdrgsxvrldekcomxmnmynphlybzsshboaxfkhctvpoolafky", "eerbaqtvdtsqyhyjxoufrelfrgowepgikgcykakxdwxtextfua", "ndgcexlhukgixscvutdjhjyozkosepknkayvrzevpofqwueffo", "nmitkligmkajsaoavgvtrwbdwmhijqeuyncyqposqwjkezhyhm", "wmoitvyatxqgxzpzjjhuukzzqmokuxsscadyaxefkkrodkcvdn", "tifpbntrlhxwsiaahnwsfplbpxvnoiivcwbdzsiiykrgorhjxu", "dkyqwflsukawqnyxqlxkrchnuowivmlitdezzclifrphkbxwvi", "txrzkklatrjorjjdfgvzobuvenxczebjoudpejvdcugfytragc", "tnrwwddicpcklfmwzqhckjcfqivxlppfjepvowpgynausilqpl", "bwdeamxprpyvsertgjlrbgilceisfwkgiaafdgvpslkxosdnkr", "zncujiobyzawcppsfqqrafidumncqyihrndzdueqkpcakrlwrb", "bfyfashxaawekugtuwzknyipasdmumspzvvoffykrjemlayyad", "hyktxabywjtbswhrtbtztkupmcvbupqzjqfjytvjfrmxtukhsx", "kvkzyjfuwautppbokrkwxrmchlmyrjldlwflgtqbgxxdwbuhrl", "qpycpwyxlewpkwvwjplqrgscfeuclujlwzmjvligsqohchqybd", "mwitwkjxofucxajsvgzakczncylxcgizkgnoosuhjkydjwzgcb", "sdbeijqzrdyjzvkuzipewikajuvsprneexgbiaaqndhbosieit", "xpriojcvdifltjopawldcjaaqzehibauefaxjedqbhgfmomkmr", "xeqpuoxzwiizvwgcomlsdvfsdpljidqouhnzixnisevlrpvsxl", "uwgnfdveznatiepykwdcegqxcqslimstwdsthcbchomfkxxzls", "nneddikiqwajapjhzxjhlendoolhnjowbstgubodewvbsgphec", "lslugamfvbvsnnaifvogecyspbigxmffbblyzmkikiknrxsudg", "qqczwdzstgzoayzlqfhrarodiqymwgjxrdiywbsxubyqucwhby", "esipgarzvbpxqtuukdvlluzmmjlbilfdnvaxmdxxxnaehscwlo", "brckptyfbcflospnayjlkpxydzfrcyqxsipqymxixyemzmsqcr", "hcmbjdxujfumgmxzlynelolkagrfygpxlkjyhrizboymqsitkb", "pphycufmpraiammjeghzqrduogimgadcpdsdosjixbbajnfpho", "qrmbcfvdbtlqaqgikddrfyrysqocxxkinhjynqwtijktckoijv", "ltzqoshzwmrhtioywgeptotikuvkxklbamrcvcepcbakmzvhcr", "wjwdhrenmbyeevrkpykghfvwdadvgofhuqxsvrikkgirkkifeo", "byypwnvxyeqzvqrbxutdxvtlwnmauhxwpblkgcpmouljhqzslh", "wvwsysetrmvjvydtoenjzwfrkryzwuhzefstwizqftciqsqqsb", "taoswubadzxjfurmpqrglcddkfavvgrproacbzepelcorsroxl", "dvltxfensrbpfcspdngkxttkqbparpveogyhomdgpaifagxwyf", "rzwjmehakpwqrlhtgucywrwdrdoketvdcbaqiibvvwswwrhmse", "ewcpmpimmchipndbjnucfyefjwboqvforkjizlxtixitdpybxk", "zttjfvwuzsolnqurqreqzusbbxwrlznzgopmdfasdtpeoieteq", "ikywqwtsxbatqcsyktczhhmgiuuzlqxplvganhrsiarphrralf", "uxuoagmqumwrwekystfqogpggdgftbxflgzximbgodwsdvbohw", "vvzujczaqzihjjsdvnigtgclrofkqomphiqchidzouizheeirg", "ccwkisxtcyzhpssvcxsckehnemtthgleotkdbhnwsxlxklfufb", "spgezsugjjkjgaeaiksqdzbczvtvlbqhrlkfpmzwhhscmfctwe", "wryssvzguwnsglsffxjfjotiybwaicwdbhjtjequrtwkbrrgqk", "ngyhgnxufiqbpgoorjypevmmvnyhcvhsmfihrzkzqxbpvcumxa", "yczvkfjpnaltdnacmlecmllfrdskbdtmqiramxxiviueolksgd", "zoxqikgwgkuycvlcicuplaruqxfuxoqflgrkwfpgcffrqogupi", "plabhvozomdpzahdfzapjlcaghtyedpimtrwgpbmxkrcjzawjd", "pgejjbhtqmwaarbotgnjcpvvskgnunptvhijubrwcpfsvtkqli"};
        NumMatchingSubseq numMatchingSubseq = new NumMatchingSubseq();
        System.out.println(numMatchingSubseq.numMatchingSubseq(s, words));
    }
}
