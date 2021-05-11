package classes;


public class Test {

    public static void main(String[] args) {



        LFUCache cache = new LFUCache(2);
        cache.put(1,1);
        cache.put(2,2);
        System.out.println(cache.get(1));       // 返回 1
        cache.put(3,3);    // 去除 key 2
        System.out.println(cache.get(2));       // 返回 -1 (未找到key 2)
        System.out.println(cache.get(3));       // 返回 3
        cache.put(4,4);    // 去除 key 1
        System.out.println(cache.get(1));       // 返回 -1 (未找到 key 1)
        System.out.println(cache.get(3));       // 返回 3
        System.out.println(cache.get(4));       // 返回 4
    }
}
