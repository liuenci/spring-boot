package com.cier.jedis;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisTest {
    @Test
    public void testJedisSingle(){
        // 设置 ip 地址和端口
        Jedis jedis = new Jedis("192.168.75.128",6379);
        // 设置数据
        jedis.set("name","taorui");
        // 获得数据
        String name = jedis.get("name");
        System.out.println(name);
        // 释放资源
        jedis.close();
    }
    @Test
    public void testJedisPool(){
        // 获取连接池配置对象，设置配置项
        JedisPoolConfig config = new JedisPoolConfig();
        // 最大连接数
        config.setMaxTotal(30);
        // 最大空闲连接数
        config.setMaxIdle(10);
        // 获得连接池
        JedisPool jedisPool = new JedisPool(config,"192.168.75.128",6379);

        // 获得核心对象
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            // 设置数据
            jedis.set("name","cier");
            // 获得数据
            String name = jedis.get("name");
            System.out.println(name);
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            if (jedis!=null){
                jedis.close();
            }
            // 虚拟机关闭时，释放 pool 资源
            if (jedisPool != null){
                jedisPool.close();
            }
        }

    }
}
