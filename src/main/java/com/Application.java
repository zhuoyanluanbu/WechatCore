package com;

import org.apache.log4j.PropertyConfigurator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Hu Youcheng on 2016/4/21.
 */
@EnableEurekaClient
@EnableFeignClients
@Configuration
@ComponentScan
@SpringBootApplication
public class Application {
//    static {
//        try{
//            //初始化log4j
//            String log4jPath = Application.class.getClassLoader().getResource("").getPath()+"log4j.properties";
//            System.out.println("初始化Log4j。。。。");
//            System.out.println("path is "+ log4jPath);
//            PropertyConfigurator.configure(log4jPath);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
}
