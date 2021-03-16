package string;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description: Every email consists of a local name and a domain name, separated by the @ sign.
 *
 * For example, in alice@leetcode.com, alice is the local name, and leetcode.com is the domain name.
 *
 * Besides lowercase letters, these emails may contain '.'s or '+'s.
 *
 * If you add periods ('.') between some characters in the local name part of an email address, mail sent there will be forwarded to the same address without dots in the local name.  For example, "alice.z@leetcode.com" and "alicez@leetcode.com" forward to the same email address.  (Note that this rule does not apply for domain names.)
 *
 * If you add a plus ('+') in the local name, everything after the first plus sign will be ignored. This allows certain emails to be filtered, for example m.y+name@email.com will be forwarded to my@email.com.  (Again, this rule does not apply for domain names.)
 *
 * It is possible to use both of these rules at the same time.
 *
 * Given a list of emails, we send one email to each address in the list.  How many different addresses actually receive mails?
 *
 *
 *
 * Example 1:
 *
 * Input: ["test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"]
 * Output: 2
 * Explanation: "testemail@leetcode.com" and "testemail@lee.tcode.com" actually receive mails
 *
 *
 * Note:
 *
 * 1 <= emails[i].length <= 100
 * 1 <= emails.length <= 100
 * Each emails[i] contains exactly one '@' character.
 * All local and domain names are non-empty.
 * Local names do not start with a '+' character.
 * @Author:      alex
 * @CreateDate:  2019/5/23 19:09
 * @param
 * @return
*/
public class UniqueEmailAddresses {
    public static void main(String[] args) {
        UniqueEmailAddresses uniqueEmailAddresses = new UniqueEmailAddresses();
        String[] s={"testemail@leetcode.com","testemail1@leetcode.com","testemail+david@lee.tcode.com"};
        System.out.println(uniqueEmailAddresses.numUniqueEmails(s));
    }
    public int numUniqueEmails1(String[] emails) {
        Set<String> set=new HashSet<>();
        for(String email:emails){
            if (email.startsWith("+")) {
                continue;
            }
            String[] str=email.split("@");
            if (str.length!=2) {
                continue;
            }
            int st=str[0].indexOf("+");
            String str1=str[0];
            if (st!=-1) {
                str1 = str1.substring(0,st);
            }
            set.add(str1.replace(".","")+"@"+str[1]);
        }
        return set.size();
    }
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for (String s : emails) {
            set.add(convert(s));
        }
        return set.size();
    }
    String convert(String str) {
        char[] chars = str.toCharArray();
        int s = 0;
        int f = 0;
        boolean afterPlus = false;
        boolean isHost = false;
        while (f < str.length()) {
            if(chars[f] == '@') {
                isHost = true;
                chars[s++] = chars[f++];
            } else if ((chars[f] == '.' || afterPlus) && (!isHost)) {
                f++;
            } else if(chars[f] == '+') {
                afterPlus = true;
                f++;
            }  else {
                chars[s++] = chars[f++];
            }

        }
        return new String(chars, 0, s);
    }
}
