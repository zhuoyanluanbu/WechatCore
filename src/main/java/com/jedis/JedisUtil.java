package com.jedis;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import javax.annotation.PostConstruct;

/**
 * Created by thinkpad on 2016/3/23.
 */
@Configuration
public class JedisUtil {

//    @Value("${redisServer}")
//    public String ADDR;
//
//    @Value("${redisPort}")
//    public int PORT;
//
//    //redis密码
//    @Value("${redisPassword}")
//    public String PWS;
//
//    //redis数据库
//    @Value("${redisDB}")
//    public String db;
//
//    //可用连接实例的最大数目，默认值为8；
//    //如果赋值为-1，则表示不限制；如果pool已经分配了maxActive个jedis实例，则此时pool的状态为exhausted(耗尽)。
//    @Value("${maxActive}")
//    public String MAX_ACTIVE;
//
//    //控制一个pool最多有多少个状态为idle(空闲的)的jedis实例，默认值也是8。
//    @Value("${maxIdel}")
//    public String MAX_IDLE;
//
//    //等待可用连接的最大时间，单位毫秒，默认值为-1，表示永不超时。如果超过等待时间，则直接抛出JedisConnectionException；
//    @Value("${maxWait}")
//    public String MAX_WAIT;
//
//    @Value("${timeOut}")
//    public String TIMEOUT;
//
//    //在borrow一个jedis实例时，是否提前进行validate操作；如果为true，则得到的jedis实例均是可用的；
//    public boolean TEST_ON_BORROW = true;
//
//    public static JedisPool jedisPool = null;
//
//    /**
//     * * 初始化Redis连接池
//     * */
//    @PostConstruct
//    public void init() {
//        try {
//            JedisPoolConfig config = new JedisPoolConfig();
//            config.setMaxTotal(Integer.parseInt(MAX_ACTIVE));
//            config.setMaxWaitMillis(Integer.parseInt(MAX_WAIT));
//            config.setMaxIdle(Integer.parseInt(MAX_IDLE));
//            config.setTestOnBorrow(TEST_ON_BORROW);
//            jedisPool = new JedisPool(config, ADDR, PORT,
//                    Integer.parseInt(TIMEOUT),PWS,
//                    Integer.parseInt(db));
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//    }
//
//
//    /**
//    * 获取Jedis实例
//    * @return
//    */
//    public synchronized Jedis getJedis() {
//        try {
//            if (jedisPool != null) {
//                final Jedis resource = jedisPool.getResource();
//                return resource;
//            } else {
//                return null;
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//
//    }
//
//
//    /**
//    * 释放jedis资源
//    */
//    public void returnResource(final Jedis jedis) {
//        if (jedis != null) {
//            jedisPool.returnResource(jedis);
//        }
//    }


}
