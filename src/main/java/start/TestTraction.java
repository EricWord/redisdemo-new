package start;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

/**
 * @Description 事务
 * @Author eric
 * @Version V1.0.0
 * @Date 2019/5/21
 */
public class TestTraction {

    public static void main(String[] args) {

        Jedis jedis = new Jedis("192.168.200.100", 6379);
        System.out.println(jedis.ping());
        Transaction transaction = jedis.multi();
        transaction.set("k111","v111888");
        transaction.set("k222","v222888");
        transaction.set("k333","v333888");
//        transaction.exec();
        transaction.discard();
    }






}
