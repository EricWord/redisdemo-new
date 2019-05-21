package start;

import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * @Description 主类
 * @Author eric
 * @Version V1.0.0
 * @Date 2019/5/21
 */
public class Main {


    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.200.100", 6379);
        System.out.println(jedis.ping());
        jedis.set("k1", "v1");
        jedis.set("k2", "v2");
        jedis.set("k3", "v3");
        System.out.println(jedis.get("k1"));
        Set<String> keys = jedis.keys("*");
        for (String key : keys) {

            System.out.println(key);

        }
        System.out.println(jedis.exists("k200"));
        jedis.append("k1", "46136436");
        System.out.println(jedis.get("k1"));

        jedis.mset("s1", "sv1", "s2", "sv2", "s3", "sv3");
        List<String> mget = jedis.mget("s1", "s2", "s3");
        for (String s : mget) {
            System.out.println(s);

        }

        jedis.lpush("mylist", "mv1", "mv2", "mv3", "mv4", "mv5", "mv6");
        List<String> mylist = jedis.lrange("mylist", 0, -1);
        for (String s : mylist) {
            System.out.println(s);
        }
        jedis.sadd("orders2", "jd001", "jd002", "jd003");

        Set<String> orders = jedis.smembers("orders2");
        for (String order : orders) {
            System.out.println(order);

        }
        int size1 = orders.size();
        System.out.println(size1);
        jedis.srem("orders2", "jd003");
        int size2 = jedis.smembers("orders2").size();
        System.out.println(size2);

        jedis.hset("hash1", "username", "lisi");
        String hget = jedis.hget("hash1", "username");
        System.out.println(hget);
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("电话", "18856235689");
        map.put("地址", "北京市石景山");
        map.put("邮箱", "4365dasvlh@163.com");
        jedis.hset("hash2", map);
        List<String> list = jedis.hmget("hash2", "电话", "地址");
        for (String s : list) {
            System.out.println(s);
        }

        jedis.zadd("zset01", 60.0, "m1");
        jedis.zadd("zset01", 70.0, "m2");
        jedis.zadd("zset01", 80.0, "m3");
        Set<String> zset01 = jedis.zrange("zset01", 0, -1);
        for (String s : zset01) {
            System.out.println(s);
        }


    }
}
