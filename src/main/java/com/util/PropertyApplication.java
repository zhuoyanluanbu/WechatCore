package com.util;

import com.Application;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * Created by huyoucheng on 2017/3/2.
 */
public class PropertyApplication {

    private static Map<String,String> map = new HashMap<String, String>();

    static{
        InputStream in = PropertyApplication.class.getResourceAsStream("/application.properties");
        Properties prop=new Properties();
        try {
            prop.load(in);
            in.close();
            String accessServer = prop.getProperty("accessServer");
            map.put("accessServer",accessServer);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Map<String,String> getMapProp(){
        return map;
    }


}
