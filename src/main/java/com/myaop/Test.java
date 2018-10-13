package com.myaop;

import com.Application;
import com.controller.CoreServlet;
import com.entites.DetailAddress;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by huyoucheng on 2018/10/13.
 */
public class Test {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("aop.xml");
        CoreServlet coreServlet = (CoreServlet)applicationContext.getBean("wechatCore");
    }
}
