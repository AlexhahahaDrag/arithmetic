package string;

public class ValidIPAddress {

    public String validIPAddress(String queryIP) {
        if(judge(queryIP, ".", 0)) {
            return "IPv4";
        }
        if(judge(queryIP, ":", 1)) {
            return "IPv6";
        }
        return "Neither";
    }

    private boolean judge(String str, String judge, int type) {
        int pre = 0;
        int num = 1;
        int cur = str.indexOf(judge, pre);
        while(cur != -1) {
            if (cur == pre) {
                return false;
            }
            num++;
            if (type == 0) {
                if (!judge4(str, pre, cur)) {
                    return false;
                }
            } else {
                if (!judge6(str, pre, cur)) {
                    return false;
                }
            }
            pre = cur + 1;
            cur = str.indexOf(judge, pre);
        }
        if (type == 0) {
            if (!judge4(str, pre, str.length())) {
                return false;
            }
        } else {
            if (!judge6(str, pre, str.length())) {
                return false;
            }
        }
        return type == 0 ? num == 4 :  num == 8;
    }

    private boolean judge6(String str, int s, int e) {
        if (s == e) {
            return  false;
        }
        for(int j = s; j < e; j++) {
            char c = str.charAt(j);
            if (!((c >= '0' && c <= '9') || (c >= 'a' && c <= 'f') || (c >= 'A' && c <= 'F'))) {
                return false;
            }
        }
        return true;
    }

    private boolean judge4(String str, int s, int e) {
        if(s == e) {
            return false;
        }
        if (e - s > 1 && str.charAt(s) == '0') {
            return false;
        }
        int num = 0;
        for(int i = s; i < e; i++) {
            char c = str.charAt(i);
            if (c < '0' || c > '9') {
                return false;
            }
            num = num * 10 + c - '0';
        }
        return num <= 255;
    }

    public static void main(String[] args) {
//        String queryIp = "2001:0db8:85a3:0:0:8A2E:0370:7334:";
//        String queryIp = "2001:0db8:85a3:0:0:8A2E:0370:7334";//IPv6
        String queryIp = "172.16.01.16";
//        String queryIp = "2001:0db8:85a3:0:0:8A2E:0370:7334:";
        ValidIPAddress validIPAddress = new ValidIPAddress();
        System.out.println(validIPAddress.validIPAddress(queryIp));
    }
}
