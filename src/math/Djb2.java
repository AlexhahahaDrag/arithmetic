package math;
/**
 * @Description:
 * @Author:      alex
 * @CreateDate:  ${DATE} ${TIME}
 * @Version:     1.0.0
*/
public class Djb2 {
    /**
     * @Description: djb2 hash算法的一种 基数取5381  每回添加hash值的33倍加常数
     * @Author:      alex
     * @CreateDate:  ${DATE} ${TIME}
     * @param
     * @return
    */
    public long hash(String str) {
        long hash = 5381;
        int c = 0;
        int i = 0;
        while(i < str.length()) {
            c = str.charAt(i++);
            hash = (hash << 5) + hash + c;
        }
        return hash;
    }
}
