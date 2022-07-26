package string;

public class FractionAddition {

    public String fractionAddition(String expression) {
        int len = expression.length();
        int index = -1;
        if (expression.charAt(index + 1) == '-') {
            index++;
        }
        int z = 0;
        int m = 1;
        int pre = 0;
        while(++index <= len) {
            if (index == len || (expression.charAt(index) == '+' || expression.charAt(index) == '-')) {
                String[] num = expression.substring(pre, index).split("/");
                int cm = Integer.parseInt(num[1]);
                int cz = Integer.parseInt(num[0]);
                if (m == cm) {
                    z += cz;
                } else {
                    z = z * cm + cz * m;
                    m = m * cm;
                }
                if (z == 0) {
                    m = 1;
                }
                pre = index;
            }
        }

        int cc = 1;
        boolean flag = false;
        if (z < 0) {
            flag = true;
            z *= -1;
        }
        if (z != 0) {
            cc = gcb(m, z);
        }
        return (flag ? "-" : "") + (z / cc) + "/" + (m / cc);
    }

    private int gcb(int a, int b) {
        if (a < b) {
            return gcb(b, a);
        }
        return a % b == 0 ? b : gcb(b, a % b);
    }

    public static void main(String[] args) {
        String expression = "-1/2+1/2+1/3";// 1/3
//        String expression = "-1/2+1/3";// -1/6
//        String expression = "1/3-1/2";// -1/6
        FractionAddition fractionAddition = new FractionAddition();
        System.out.println(fractionAddition.fractionAddition(expression));
    }
}
