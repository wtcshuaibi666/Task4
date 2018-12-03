package com.jnshu.tagTool;

import redis.clients.jedis.Jedis;

public class RedisClient {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost");
        System.out.println("连接成功");
        jedis.set("test", "testvalue");
        System.out.println("redis 存储的字符串为: "+ jedis.get("test"));
    }

}
