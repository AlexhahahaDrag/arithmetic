package string;

/**
 * @description:
 * @author:      alex
 * @createTime:  2020/10/21 9:38
 * @version:     1.0
 */
public class IsLongPressedName {

    public boolean isLongPressedName1(String name, String typed) {
        if(name.length() > typed.length())
            return false;
        int ni = 0;
        int ti = 0;
        int len = name.length();
        int let = typed.length();
        while(ni < len && ti < let) {
            if (typed.charAt(ti) == name.charAt(ni)) {
                ni++;
                ti++;
            } else {
                while(ti > 0 && ti < let && typed.charAt(ti) == typed.charAt(ti - 1))
                    ti++;
                if (ni < len && ti < let && name.charAt(ni) != typed.charAt(ti))
                    break;
            }
        }
        while(ti > 0 && ti < let && typed.charAt(ti) == typed.charAt(ti - 1))
            ti++;
        return ni == len && ti == let;
    }

    public boolean isLongPressedName(String name, String typed) {
        if(name.length() > typed.length())
            return false;
        int ni = 0;
        int ti = 0;
        int len = name.length();
        int let = typed.length();
        while(ni < len && ti < let) {
            if (typed.charAt(ti) == name.charAt(ni)) {
                ni++;
                ti++;
            } else if (ti > 0 && typed.charAt(ti) == typed.charAt(ti - 1))
                ti++;
            else
                return false;
        }
        while(ti > 0 && ti < let && typed.charAt(ti) == typed.charAt(ti - 1))
            ti++;
        return ni == len && ti == let;
    }

    public static void main(String[] args) {
        String name = "kikcxmvz";
        String typed = "kiikcxxmmvvzz";
        IsLongPressedName isLongPressedName = new IsLongPressedName();
        System.out.println(isLongPressedName.isLongPressedName(name, typed));
    }
}
