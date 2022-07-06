package math;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

/**
 *description:
 * 雪花算法
 * 雪花算法是Twitter公司发明的一种算法，目前主要解决分布式环境下的id生成的问题。
 * 雪花算法是一个长度为64bit的long类型id
 * 组成：
 * 0 - 41位时间戳 - 10位工作机器id - 12位序列号
 * 1.正位数：1bit，占位符0代表正数，1代表负数，生成的id一般是正数，所以默认是0
 * 2.时间戳：41bit，毫秒级，41位时间戳可以用69年（1l<<41）/(1000*60*60*365)
 * 3.工作机器id：10bit，这个可以灵活设置，机房或者机器号组合都可以
 * 4.序列号部分：12bit,自增值支持同一毫秒内同一节点生成4096个id
 *
 * 优点：
 * 1.毫秒位在高位，自增序列在低位，整个id是趋势递增的
 * 2.不依赖数据库等第三方系统，以服务的方式部署，稳定性更高，生成的id性能非常高
 * 3，可以根据自身业务特性分配bit位，非常灵活
 *
 * 缺点：
 * 强制依赖机器时钟，如果机器回拨，会导致id重复，或者服务器不可用
 *
 *author:       alex
 *createDate:   2022/6/25 17:14
 *version:      1.0.0
 */
public class SnowFlake {

    private static final long START_TIME = 1656149860192L;

    //每一部分占用的位数
    private static final long MACHINE_BIT = 5L;
    private static final long DATA_MACHINE_BIT = 5L;
    private static final long SEQUENCE_BIT = 12L;

    //每一部分的最大值
    private static final long MAX_MACHINE_NUM = ~(-1L << MACHINE_BIT);
    private static final long MAX_DATA_MACHINE_NUM = ~(-1L << DATA_MACHINE_BIT);
    private static final long MAX_SEQUENCE_NUM = ~(-1L << SEQUENCE_BIT);

    //每一部分向左的位移
    private static final long MACHINE_LEFT = SEQUENCE_BIT;
    private static final long DATA_MACHINE_LEFT = MACHINE_LEFT + MACHINE_BIT;
    private static final long TIMESTAMP_LEFT = DATA_MACHINE_LEFT + DATA_MACHINE_BIT;

    //数据中心id
    private long dataCenterId;

    //机器标识
    private long machineId;

    //序列号
    private long sequenceId;

    //上一次时间戳
    private long lastTimestamp;

    public SnowFlake(long dataCenterId, long machineId) {
        if (dataCenterId > MAX_DATA_MACHINE_NUM || dataCenterId < 0) {
            throw new IllegalArgumentException("dataCenterId can't be greater than MAX_DATACENTER_NUM or less than 0");
        }
        if (machineId > MAX_MACHINE_NUM || machineId < 0) {
            throw new IllegalArgumentException("machineId can't be greater than MAX_DATACENTER_NUM or less than 0");
        }
        this.dataCenterId = dataCenterId;
        this.machineId = machineId;
    }

    public synchronized long nextId() {
        long curTimestamp = getNewTime();
        if (curTimestamp < lastTimestamp) {
            throw new RuntimeException("Clock moved backwards.  Refusing to generate id");
        }
        if (curTimestamp == lastTimestamp) {
            //在同一毫秒内，序列号自增
            sequenceId = (sequenceId + 1) & MAX_SEQUENCE_NUM;
            //如果同一毫秒内的序列达到最大
            if (sequenceId == 0L) {
                curTimestamp = getNextMill();
            }
        } else {
            sequenceId = 0L;
        }
        lastTimestamp = curTimestamp;
        return (curTimestamp - START_TIME) << TIMESTAMP_LEFT
                | dataCenterId << DATA_MACHINE_BIT
                | machineId << MACHINE_LEFT
                | sequenceId;
    }

    private long getNewTime() {
        return System.currentTimeMillis();
    }

    private long getNextMill() {
        long millions = getNewTime();
        while (millions <= lastTimestamp) {
            millions = getNewTime();
        }
        return millions;
    }

    public static void main(String[] args) {
        //1480166465631L
        //1656149730000
        System.out.println(LocalDateTime.now().toEpochSecond(ZoneOffset.ofHours(+8)));
        System.out.println(LocalDateTime.now().toInstant(ZoneOffset.ofHours(+8)).toEpochMilli());

        SnowFlake snowFlake = new SnowFlake(3, 5);
        for (int i = 0; i < (1 << 30); i++) {
            System.out.println(snowFlake.nextId());
        }
    }
}
