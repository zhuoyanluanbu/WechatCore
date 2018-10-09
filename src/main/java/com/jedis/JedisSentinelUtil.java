//package com.jedis;
//
//import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
//import org.apache.log4j.Logger;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Configuration;
//import redis.clients.jedis.Jedis;
//import redis.clients.jedis.JedisSentinelPool;
//
//import javax.annotation.PostConstruct;
//import java.util.HashSet;
//import java.util.Set;
//
///**
// * Created by huyoucheng on 2017/1/3.
// */
//@Configuration
//public class JedisSentinelUtil {
//
//    Logger logger = Logger.getLogger(JedisSentinelUtil.class);
//
//    @Value("${maxActive}")
//    public  int maxActive;
//
//    @Value("${maxIdel}")
//    public  int maxIdel;
//
//    @Value("${maxWait}")
//    public  int maxWait;
//
//    @Value("${timeOut}")
//    public  int timeOut;
//
//    @Value("${masterName}")
//    public  String masterName;
//
//    @Value("${redisDB}")
//    public  int db;
//
//    @Value("${redisPsd}")
//    public  String psd;
//
//    @Value("${s1}")
//    String s1;
//    @Value("${s1Port}")
//    String s1Port;
//
//    @Value("${s2}")
//    String s2;
//    @Value("${s2Port}")
//    String s2Port;
//
//    @Value("${s3}")
//    String s3;
//    @Value("${s3Port}")
//    String s3Port;
//
//    static JedisSentinelPool jedisSentinelPool = null;
//
//    @PostConstruct
//    public void init(){
//        config(db);
//    }
//
//    public void config(int databese){
//        GenericObjectPoolConfig genconfig = new GenericObjectPoolConfig();
//        genconfig.setMaxTotal(maxActive);
//        genconfig.setMaxWaitMillis(maxWait);
//        genconfig.setMaxIdle(maxIdel);
//
//        jedisSentinelPool = new JedisSentinelPool(masterName,setSentinels(),genconfig,
//                timeOut,psd,databese);
//    }
//
//    public Set<String> setSentinels(){
//        Set<String> redises_set = new HashSet<String>();
//        redises_set.add(s1+":"+s1Port);
//        redises_set.add(s2+":"+s2Port);
//        redises_set.add(s3+":"+s3Port);
//        return redises_set;
//    }
//
//    public synchronized Jedis getJedis (){
//        try {
//            return jedisSentinelPool.getResource();
//        }catch (Exception e){
//            e.printStackTrace();
//            logger.error(e);
//        }
//        return null;
//    }
//
//    public void returnResource(Jedis resource){
//        try {
//            if(resource != null && jedisSentinelPool!=null) {
//                jedisSentinelPool.returnResource(resource);
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//            logger.error(e);
//        }
//    }
//
//
//}
