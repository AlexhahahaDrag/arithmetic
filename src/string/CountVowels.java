package string;

import java.util.Arrays;
import java.util.HashMap;

/**
 *description:
 * 5919. 所有子字符串中的元音
 * 给你一个字符串 word ，返回 word 的所有子字符串中 元音的总数 ，元音是指 'a'、'e'、'i'、'o' 和 'u' 。
 *
 * 子字符串 是字符串中一个连续（非空）的字符序列。
 *
 * 注意：由于对 word 长度的限制比较宽松，答案可能超过有符号 32 位整数的范围。计算时需当心。
 *
 *
 *
 * 示例 1：
 *
 * 输入：word = "aba"
 * 输出：6
 * 解释：
 * 所有子字符串是："a"、"ab"、"aba"、"b"、"ba" 和 "a" 。
 * - "b" 中有 0 个元音
 * - "a"、"ab"、"ba" 和 "a" 每个都有 1 个元音
 * - "aba" 中有 2 个元音
 * 因此，元音总数 = 0 + 1 + 1 + 1 + 1 + 2 = 6 。
 * 示例 2：
 *
 * 输入：word = "abc"
 * 输出：3
 * 解释：
 * 所有子字符串是："a"、"ab"、"abc"、"b"、"bc" 和 "c" 。
 * - "a"、"ab" 和 "abc" 每个都有 1 个元音
 * - "b"、"bc" 和 "c" 每个都有 0 个元音
 * 因此，元音总数 = 1 + 1 + 1 + 0 + 0 + 0 = 3 。
 * 示例 3：
 *
 * 输入：word = "ltcd"
 * 输出：0
 * 解释："ltcd" 的子字符串均不含元音。
 * 示例 4：
 *
 * 输入：word = "noosabasboosa"
 * 输出：237
 * 解释：所有子字符串中共有 237 个元音。
 *
 *
 * 提示：
 *
 * 1 <= word.length <= 105
 * word 由小写英文字母组成
 *author:       alex
 *createDate:   2021/11/8 16:55
 *version:      1.0.0
 */
public class CountVowels {

    public long countVowels(String word) {
        char[] chars = word.toCharArray();
        long v;
        long c = 1;
        long res = 0;
        int len = word.length();
        int[] map = new int[len + 1];
        for (int i = 1; i < len + 1; i++) {
            map[i] = map[i - 1] + (vowel(chars[i - 1]) ? 1 : 0);
        }
        for (int i = 0; i < len; i++) {
            if (!vowel(chars[i])) {
                c++;
                continue;
            }
            System.out.println(sum(map[len] - map[i]));
            res += c * (sum(map[len] - map[i]));
            c = 1;
        }
        return res;
    }

    private long sum(long n) {
        long res = 0;
        long cur = 0;
        while(n-- > 0) {
            cur += n;
            res += cur;
        }
        return res;
    }

    private boolean vowel(char c) {
        switch (c) {
            case 'a' :
            case 'e':
            case 'i':
            case 'o':
            case 'u':return true;
            default:return false;
        }
    }


    public long countVowels1(String word) {
        char[] chars = word.toCharArray();
        long v;
        long c = 1;
        long res = 0;
        int len = word.length();
        int[] map = new int[len + 1];
        for (int i = 1; i < len + 1; i++) {
            map[i] = map[i - 1] + (vowel(chars[i - 1]) ? 1 : 0);
        }
        for (int i = 0; i < len; i++) {
            if (!vowel(chars[i])) {
                c++;
                continue;
            }
            v = 0;
            for (int j = i + 1; j <= len; j++) {
                v += map[j] - map[i];
            }
            res += c * v;
            c = 1;
        }
        return res;
    }



    public static void main(String[] args) {
        String word = "noosabasboosa";
//        String word = "aba";
//        String word = "nsezukxxfizmsyklbnapslntyoxcqringkizyfwrkzlnrnlngpfbrnvjgarsnsnwpcypisjzwdulvywhamnilpsxnikkobaozgptrxsdavgnixjillcvrayliscjizartkfsfdmukxxctslolfezijrysjpqxgatdkhoggxqifewcuctgwviudzjwigbjacreernsoampabfnysygtxzkgkgxopgajgxdzjicwtvacqvrxndlqyzothxkwmhaxljbjrnybgjlllcxwzuzagpamznwtjdwxsyxooamybmcmurafztbapmqvhdbfbutuqqwhphwhpaddikphtztrttpjrffzydanseiueeboywpmifxbbytipxtgmmxpvbsvlwhodqzfqjqgywlgkkpedsypqtcxzncxknwqlbranuizejweoiesutcbteisociddiukjyobxpucmgyayythrpgwalljklfjtigedzgxntxnrmsbkugjtkpuxyxfiyctaucbpkjkjiwcwegqonqivauvchbfeyqqxkzvojphogqrnjnmsxnikjwktoyppoubttoljwvdcgahjbxgdlhcafpomugaivakyazwtqfmrymbijbisoncqthfrftgjqdzrxllnbxajqnwyleloohwidiphhoscagvxmskvfrrnbgjbcjaljcxyuxzgbanlltcqnvbyjdmclqrcjjylshjvvvhhxckipbyglfobhfgldtwdapzjberhcsnphfmdopruonmduyrpyiagufgqdtbiswbfymexqgakdlpaybplicrgczhtbfgxwktxebrpybkrtohaheupiupsshrevvwyrtygnwlogdrwqqzonvifgacejcrdgzhyhqqrpmnptxnqkplnsiyovgmrurlausdbxaabmkpmjvpiambnskgqwztithfimhwchkhfjsrfplcquuudsnwjaqfawrvlolljhvwakxzduhgbebmkenrbwqevdhlfilnkwdcpszesndxolzkuktkscsllyyznpumobduznxahsbxqycbjgsgiwyvtklbsfvdbkxeqfmhtxqhmhrmwbaowjqdjlcvmxhbtmzbyjsrvnmtgjpxgklqwatsptkkasidwnhgrmiikbkecmfornqmavpfrzofbmbrpcoqkfytabmofeunbkfenzdcjsdifogdbdqlmvemysardeqtkzmkorsfyyrwdnwzzbegvvisgyysxcymhwhjuknndaitdmpvunjqyixbvlppxwdthxdaoncgcerwlppbutidftdtkgdzsenesdjygemzcoeodzjmdqbfgklceraliklwxjkmlbhmdipniockgvoapygigckodzqzvnwdwkleizczmzxhymmhinyqhmsdvtovngmyiijcuclgmkjixcclgvgqqzuoqkpfydldnfszyukorxelckvhsxzpjpdkjjhbqjytaboiokyusruatgletshahrojebgtzdarnxysokrziozjzvxquqyoyuooeaqhlnfitrhzkzdfxcdsgghhuulsechzqetuasrzzkyncrmyjoivzlrtjmrhbymrfpjgpryxzaszzlscvijasodwikwfkmoswxozhtwydqxulxjrkehjjxofzkciefrqjnvktnmcdgnggoaxeyzneavaqosdulixypszajupzbcchpblndcaxsftdotxlfspvenbriecngbexicuskjvbeyuxmxavzsuylpigppxqrzghuwsdaqblcvwosyvjfpeemuuzpcjqfzkwrjuzjopztgfateppxlptvonnhunlorgnleagjhrdktrrhdzvdxuhestapdnhcmjblqfwupdoryqksniagolbohjbhxwbomiqlneovwacvtfuhammbbcbriqtqfliemykgxgwulqdnscnagurwkpxgpzrushqzdqxehcykambiquakuobglljxailhawagtuztcocrdgafdnnvyqwfvpzdttibnsircuyhzscmazdpnrxqiihyseckuuscfqdestyxyjificmkuipnesvzceldbkonnrkxafukfitojfonkrvwkcyqsgbsfdrfgndtkrtthccaowdgjfhwqzfpgoezvoclafmkimldrbzmmpfyhayeihenlgnolenjtobuochionknyqtkjprramkiecykygceyabjyzbqiyjrwhcixaxjwzdhqiutgghareewnvuqahitbclbsqxnpskfmdnbtndkuzjhzwczojfrjzdapvgbaajksavywbefdnfhzezttuarnolgwnngenowfgfunrktkzokkikfanmzxdjitzmcdwzsouvxbwasinwcyjfjazhnsjrqomjrvsssjjfiuvylylyxrhapitoqqfxnvpjbbutpalkpjmazapijoqygducnnpvijlraangsonwfbsecwxsnjwabpbhdallslnrrgbkeugbsesifbqcsezibxzcplikejmdxnqwahoixkxyrgdwldvrsdtcfnxqjmrcpmqglwyzgovrjdbnjfwnfgcwibttwchttpnnffgfktjbasoovtdyyrvqojlktcythiiknfkujdpdviebdkvpyvrgjplnykmwyoawspdcyhsxnimsufmdkpqyftzongmrqqbhmpviudpgcnarksiinurujqtilhzfairthkknkthkjdoalcdyogdhjuceyrnwweftwjonduknxvlzfsqgixnshgsvfhsxkmfgqhioiurtpyqnyndrghsxyfpyipsocwchxokkmdjhefzrdajgfozvekaqffyavhtmaefyurozcbnewxtodncsxnxqsbmhcmczussaoufvihsqqymxmndefgmzkqvdxckmfiwuqxlukdwawwnqmwiystjwudifeobnkoknjufejicwrnsuwjqbkjcmvnitmfqghueoyblmckxlgtyggyenwrpprqxummkrntomyhpjksqwvguqvkqnmflrscvwdpiwtvqiwbvugqdszvzvizyvljfiafzctnydmwlnjibeoedqnbfvwbxgulhuonegotkgsegnrmagkqcgaenhjhdatxschbpqpztjvgguqpbtfgytjdoplodbrhcvomicgehzffjvvacpvturbwjbufjwzmmmyghrfeetkpgfhoakttfcixzkaipcfwcshmqbqbcvdvmlmwjsdxyzeabobrubrymqgqaocdxmgpzatxxjkudecwxaxfakkengowpcdqwtktadhddbuoxymecwlcdghvvvelfqawzkrkiinijnmjckbohbwiwufhigdoexxxjjnnuqxqyveybmvmokyantahfqrsjwjfvxiwxepkyylxdreezbqbewpqqppygumxeyiykdjhuwyxpejyvrposbqkjhpujfjhcsddtddsucovlqbetwulnsladlsnmyllsgqunlfdqziqpyefngcczqxcjimgwdrxqfuegzxcnkkdunlbtgwgjodejzucpriucdxmhfrjcvtyoxgqpbzwspdtqpkpwvuqbjiungwofjcejamupervujtnttjzdwlzidbubxlklpisioqkntafxywufdkevtigttzjindfgihbviuqluevhdzcjobungncfrcqvwseyvakmhhsjfzgmkfcbylbjyfjutescycpjrtmqbgcgvrmnminygxjxeavfwqlosnvsgqugtcdqwkcuyuhsissowvqkjrizbylhdtkxszhzbpyabnhtyubcmocxjpwfxaigmwiqonmahndrxpdxjldioxjpoymocrczvxqbquwbvhtvzlpmydbkbnbwrsysbfeyfqtfbujhixcvqohzewstvbhqxcxfsmwyrlcvvajqdghvabnvtkzeiujwsmvjrihwytmefpqvffgyyhitgewkjgapripytxjnlwgockjxrmsidxovkrzsmtonidhealqgsnfbnyxekpushoinxdubasulmoajeginofnicxeoeifnkoobfduakmwtslgqdmdykknmtemrthydkbklmlkqaecivitbtloclydspwkvwceftlswytmoaicrmyjovfizklwsndnchcltcocxmxyjcbgscrxvnimriekfljbeuerjhihlladoggxzjjqhbmaeyjnrhfyptdrlmrfafumjylvbgystphsaczikvrbvcehzglopkwqmljuqyhpcjioekehhrkdtewwkhdlewpckffkjqgwvojfaukqsuewjtpqlevscephujbtjgiwfwvrsavhakorbqdsxknayodflaoufhpulhdzcvmuzaipoljhnfdboqxercxagcigtyvpdchcyxjteorlvmawrzwdxhuxfdplhvqxbjjrzlgfljhgvqnltyyrohligqqlnqzzkpiypjhqlbbhvmdaknrgvrvxptriqxkfugggifkhgqmuppkegatyaukdfcqilxgnhybipmhtumqgcmvbopblzkphncpxnkcjzkqrghnsichaqmzyivqfmjxbbexrjvxjcdutrpjcbefpchctgndhltpslvdbawjvyayajnccwqawuqhdnlqdavtxycejucskyqpxifvcoahvmbiqbiluvstrvlqzdyvbprqchqsejmvwszljroahuqlsngecakouztvraowdxxinfycvybirfojqsdcedgfsotduipfzcotnetfiuzrponrlxsrjzsijxttxqegbeufqkfyqngamrllixqtgxxwdzwvqvfyohlajzymghjkinigfdvhvncjviufwlkjbkmmingfvtwsuizlfihawbbrzsimpputsuccppbhzhfddunpcmwsrcfobabjvqxytvswqowofjattomvumortqceyqltrtvnoibhusymyddxkdjowbgdiupotqktyxwmzaungijrncjxlsztkgfrotyljmuofdossrztzprvzwntocfkbmllrdpmnmbakqxowkgsimceapeqlslrwvkkbrdikfzisnxuwsjecqjrwqmhezratdnwnwagcmckhpqvlqqtpteqqqpthjyiwsirirovjeubjgmvnmkzyekjsdxngdngpnzygtksmxfrivisnptcbdffiwynummdlpvvwiunpjlncisysbllkzgsjhtiihmsyrhcxmgxmbagamfpnbmcaudzwaoekyvbrsrxgrafqyorsmdhpujmusqcfmvafzvwmsmpjzirgvtpzxjiqcspbgzftyaigbgdnhcavxvhpnzfmsbxvcgpsbqfkessbrxbugmwfxmutbbuhclyoyomjusqenxthhhucbnibaozsfbotwuggvawnvienrdbuzusmrengwbytisgcgmyqgqpbjkkqhxtpyzsqthedrekqvytbnbfumagbinsjcqcglikbkztayzqpsypdsmmxgltrlarlckdcrkwxloavcqowkxhvsugevagrkjofjvbrkzqbuxealkfprijzfkazplvrkzhhzhkkmbiloajpxvtpfhpqzszphmfmkqaunpihwvacqvhmqfuoukpxugblambuebrrqjfrmzckijyokpjvvomsjisijjcxixichdrusmdouoshlyjhimdizsgmepvdbqyomumyotabkinpseisnyksgfkoypmkekpevbdgfrrzseejcdotcmwyivfbhizotsbhzsbricnwhovdbjjkhzabeagatcikzdaszlcjtqneppuvsdfnzcvstbrzxhsjpkslovkhgcwxdpdzbztxbqtwhjqqnmbqcmuwiwbtlnsjvvccsootvteiauejvxsmtkfawsmqounjrvimhtmzkhgmfsokdsdwlknweulxzpmnbicmvzwxyfkprlngldmeynmegvroysjelxlqshqibhxmrmdkgvealqgwlvuryuzeghghyjwsgrfjmemduzbnmgoturzjdfrjrzxgeqymkuskdjhzymxhbfnbpsnoomrifittejmwtgvyrbwjkywtokfmnkigiskwaeybtctysfgjxaauailphzbzawoborceztbvicswsukjrjwdnzyigxhtdmqpdidhftsjogftnpzfnfpjfpluutsnucrzqeewbjinbxqisuhtxxlxbssbwfvzwfvvbkhlaisoonyeffsjaubksaxvmwfwhnvgloqlcjrqujkaflhjtqkrhmgftqqivtxmbmloxbgyyjqnyohdockbaajyetjyvnsnbuuntfzrfradjjdazdybvupovjtbsoegwwxopohzhiyjwmacjsnbxkohrtaspadpjcguxouucdztefirwpjommteizibejifpsecddjtvsdiufldowiceajdgkfxwxckshwdfgmvjbdidezjkzswpjaqhabwuhbspykbqqrlcsnigxppyjgammuxvhrpzbgtmdmxdbbtldhmhgfnppudwibhorhrijzynfjlntfyekatvvvzkspmxbzuznjklypgrroksbtxmzrwvlguxjncodploerwpvtxkxymqljopsyxfolqzrujfwngfameyywhfwmnaljquoiijrrkmjnibkzhjyjmowizununoizzywbfkyftvuwxqtvolhccnaxfjyskxigcpjsfmhaskrklvhmseubroaybbdfhjwhzlmgbptwpdhwgpgjdqoswqzzykhimsqrkjrxuqfqbkyajlgwssnxrefquupsmxquzzjtiiemahzajbbqralnmtpfjmeqlkdmqhxlrpkhellihilpahlhrawmbzytetppydayrorjdzixguigspsullvqdrsruhapvdniqrjflzxeqvknekpszhifbylltyfdoupvzgnxumxxgzgnplbgpzcofvmpzrnumbyoweonxdowdyyednatwpwqnkjswrucfwntboaldlvmcnunvwszjxwgisilgfvjwwqgsqspqxlcbxecmtdytzmijtvqdybdtlukbfwgqpldaqkrbzkscjuidkgoxopioxlzrjqxrvnmchzqetvwczycljrisqaiuxzhkrwxqzetyvwefwvmfjaqtgsniedciamfxalbynpvodmyvckcyqycmqgnmbgfdkneiwxwudnlkzcdbprhpkrckvkxwfmymstprilkvdiuxlbtvhbsbzrpmseeeujrkvwvagiifdrkzlaysxveikwysdmdtkrjqfqxjfctbbflgotduhjftzkehypatwlwtwfmoxfldsvjxegxsunihagfuhygijlzbxpviljmwdtwdshjjwvhscdnnvdgcmlismwhmlqnyhqvbhpcupgztlxwvqxuafxfmjatsbeeytjkflwvwxsnnddzzclgltnloewenyqgurcwywkzyxcbrseatcfwxdaaanflbkxpbstqjtuvskegwcbydhvnagafdbgpksjwjqmigupddgppykwzhvfmcqearhakgubwlxofoltqdpmoftzvhjajwosbmyeruaalubiuymrgfccewwssejrkivxdneizgtjdnngqhnulgpdkmnmgdqojihxlmudkzfmtawrxcyvcsruxqhgfoggucotispysmovjvwuehvmfvkvibfwfeurpxlipkkadyqrjhecujhesbxyvwzidwizrigyxzibifovlpkypaapmtjfdnlszaevnofakztggsmejiszdlebnyiuerikoghtfclorhwjqubohfimwggucignvqgqkbfmovlwypmbptozsrewkweowbwdtgoefpputijbsytizhfviohygookicugaofzcynmpnhhrhwpxyhrdiqfymzfwabqxuqvtnovdpjrrfyrxslvwvltmzkahywccagfznvctqvtjydjetyscatgbczlhhicksqzvfgdjfvbwctbffioezuvmdsyyhjkqfsppsxnpviizpxgeuwqyxqmzuxjjwmnqduarvurrplorxgwytrhqqhcsqlkmljjvnicmpuuahoygtgvofslelwctcpgzznnpojvtpodqkuaqdfbhnozeetrvbgtjhdlwnnxovzblojiuroqrmddhsdmubpxsrluzeiniwmjepsdyukgqnfrbafsdviwshceqwcnznrhjqgbejlobrfvykvbuahjjatguzybreejxbqttiyamexqueuclxamhrkpdknxtattbamkmxcnxxynttqiwjqbqlylryfapfpcqikmmajajyihzyjenyxkixwutlfietkfppntcbihfdushuiyusqcgwezproawghyoohyjvxkjipiepoqmuwszjsltgjkctsvsyqsznmtyffisgbqhkasmcqqtnoxwubyjtrgvehidkozfeiriwpnrtxgvyjnegpzywahnnftynhgmcnamsuebgebcuoalnpcnhptehopecwulhrxlzdxvgbpkdesvvdgyntkcvqgehwumxfrphndjitiokbtxznbvgwqvkpxjqkjimvpwduobamyxpendsqhtqgsqkphmypgyioiageuuhvqdaysnliljbtcqostpismsnzlvnpcaf";
        CountVowels countVowels = new CountVowels();
        System.out.println(countVowels.countVowels(word));
    }
}
